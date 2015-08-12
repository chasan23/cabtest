package com.cabtest.agent;

import com.cabtest.model.Booking;
import com.cabtest.service.BookingRegisterService;
import org.springframework.core.task.TaskExecutor;

import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class AgentExecutor {

    private TaskExecutor taskExecutor;
    private AssignmentAgent assignmentAgent;
    private BookingRegisterService bookingRegisterService;
    private BlockingDeque<Booking> bookingQueue;

    public AgentExecutor(TaskExecutor taskExecutor, AssignmentAgent assignmentAgent, BookingRegisterService
            bookingRegisterService) {
        this.taskExecutor = taskExecutor;
        this.assignmentAgent = assignmentAgent;
        this.bookingRegisterService = bookingRegisterService;

        List<Booking> bookings = bookingRegisterService.getUnassignedBookingList();
        bookingQueue = new LinkedBlockingDeque<>(bookings);
        assignmentAgent.setBookingQueue(bookingQueue);

        taskExecutor.execute(assignmentAgent);
    }


}

