package com.adobe.aem.newsportal.core.listeners;

import com.day.cq.replication.ReplicationAction;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        service = EventHandler.class,
        property = {
                EventConstants.EVENT_TOPIC + "=" + ReplicationAction.EVENT_TOPIC,
                EventConstants.EVENT_FILTER + "=(&(type=ACTIVATE)(paths=/content/newsportal/*))"
        },
        immediate=true
)
public class ArticleActivationHandler implements EventHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ArticleActivationHandler.class);

    @Override
    public void handleEvent(Event event) {
        ReplicationAction action = ReplicationAction.fromEvent(event);

        if (action != null) {
            LOG.info("Article Activated! Path: {}", action.getPath());
        } else {
            LOG.warn("Replication event received, but ReplicationAction is null");
        }
    }
}
