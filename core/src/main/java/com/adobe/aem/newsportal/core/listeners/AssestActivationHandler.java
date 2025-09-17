package com.adobe.aem.newsportal.core.listeners;

import com.adobe.aem.newsportal.core.utils.NewsportalUtils;
import com.day.cq.dam.api.DamEvent;
import org.apache.sling.api.resource.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        service = EventHandler.class,
        immediate = true,
        property = {
                EventConstants.EVENT_TOPIC + "=" + DamEvent.EVENT_TOPIC
        }
)
public class AssestActivationHandler implements EventHandler {

    private static final Logger LOG = LoggerFactory.getLogger(AssestActivationHandler.class);

    @Reference
    NewsportalUtils utils;

    @Override
    public void handleEvent(Event event) {
        LOG.info("Starting of Event");
        DamEvent damEvent = DamEvent.fromEvent(event);
        if (damEvent == null) return;

        String assetPath = damEvent.getAssetPath();

        try (ResourceResolver resolver = utils.getResourceResolver()) {

            Resource data = resolver.getResource(assetPath+"/jcr:content/metadata");
            if (data != null) {
                ModifiableValueMap properties = data.adaptTo(ModifiableValueMap.class);
                if (properties != null) {
                    properties.put("assetValue", data.getName());
                    resolver.commit();
                }
            }

        } catch (Exception e) {
            LOG.error("Failed ",e );
        }

    }
}
