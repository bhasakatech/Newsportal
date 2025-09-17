// package com.adobe.aem.newsportal.core.Services;

// import com.day.cq.replication.ReplicationActionType;
// import com.day.cq.replication.ReplicationException;
// import com.day.cq.replication.Replicator;
// import com.day.cq.workflow.WorkflowException;
// import com.day.cq.workflow.WorkflowSession;
// import com.day.cq.workflow.exec.WorkItem;
// import com.day.cq.workflow.exec.Workflow;
// import com.day.cq.workflow.exec.WorkflowProcess;
// import com.day.cq.workflow.metadata.MetaDataMap;
// import org.osgi.service.component.annotations.Component;
// import org.osgi.service.component.annotations.Reference;

// import javax.jcr.Session;


// @Component(service = WorkflowProcess.class,
//         immediate = true,
//         property = {
//         "process.label=NP-cobtent Activation Process."
//         }
// )

// public class NPActivationProcess implements WorkflowProcess {

//     @Reference
//     Replicator replicator;


//     @Override
//     public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {


//         Session session = workflowSession.adaptTo(Session.class);

//         String payLoad= WorkItem.getWorkflowData().getPayload().toString();
//         try {
//             replicator.replicate(session, ReplicationActionType.ACTIVATE, "");
//         }catch (ReplicationException e){
//             throw new RuntimeException(e);
//         }
//     }
// }
