package site.zido.elise;

import site.zido.elise.events.SingleEventListener;
import site.zido.elise.http.Request;

/**
 * The interface Operator.
 *
 * @author zido
 */
public interface Operator {
    /**
     * Cancel.
     *
     * @param ifRunning the if running
     */
    Operator cancel(boolean ifRunning);

    /**
     * Pause boolean.
     *
     * @return the boolean
     */
    Operator pause();

    /**
     * Recover.
     */
    Operator recover();

    /**
     * Add url operator.
     *
     * @param url the url
     * @return the operator
     */
    Operator execute(String... url);

    Operator execute(Request request);

    Operator addEventListener(SingleEventListener listener);
}