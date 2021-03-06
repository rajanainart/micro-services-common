package com.rajanainart.integration.querybuilder;

import com.rajanainart.data.BaseMessageTable;

import java.util.List;
import java.util.Map;

public interface DbSpecficQueryBuilder {
    String delete     (BaseMessageTable config, Map<String, String> requestParams);
    String bulkUpdate (BaseMessageTable config, List<Map<String, Object>> records);
    String rowUpdate  (BaseMessageTable config, Map<String, Object> record);
}
