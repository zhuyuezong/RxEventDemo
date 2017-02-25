package com.ternence.tevent.annotation;

import com.ternence.tevent.Bus;
import com.ternence.tevent.finder.AnnotatedFinder;
import com.ternence.tevent.thread.EventThread;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a method as an event subscriber, as used by {@link AnnotatedFinder} and {@link Bus}.
 * he method's first (and only) parameter and tag defines the event type.
 * If this annotation is applied to methods with zero parameters or more than one parameter, the object containing
 * the method will not be able to register for event delivery from the {@link Bus}. Bus fails fast by throwing
 * runtime exceptions in these cases.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {
    Tag[] tags() default {};

    EventThread thread() default EventThread.MAIN_THREAD;
}