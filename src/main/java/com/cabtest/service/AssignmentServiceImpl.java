package com.cabtest.service;

import com.cabtest.dao.AssignmentDAO;
import com.cabtest.dao.GenericDAO;
import com.cabtest.model.Assignment;
import org.springframework.stereotype.Service;

@Service
public class AssignmentServiceImpl extends GenericPersistenceServiceImpl<Assignment, Integer>
        implements AssignmentService {

    private AssignmentDAO assignmentDAO;


    public AssignmentServiceImpl() {
        super();
    }


    public AssignmentDAO getAssignmentDAO() {
        return assignmentDAO;
    }

    @SuppressWarnings("unchecked")
    public void setAssignmentDAO(AssignmentDAO assignmentDAO) {
        super.setGenericDAO((GenericDAO) assignmentDAO);
        this.assignmentDAO = assignmentDAO;
    }

}
