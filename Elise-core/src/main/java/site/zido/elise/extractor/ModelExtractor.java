package site.zido.elise.extractor;

import site.zido.elise.Page;
import site.zido.elise.ResultItem;

import java.util.List;

/**
 * model extractor
 *
 * @author zido
 * @date 2018/04/18
 */
public interface ModelExtractor {
    ResultItem extract(Page page);

    List<String> extractLinks(Page page);
}