package com.rajanainart.upload.task;

import com.rajanainart.integration.querybuilder.DbSpecficQueryBuilder;
import com.rajanainart.integration.task.ImportIntegrationTask;
import com.rajanainart.upload.UploadConfig;
import com.rajanainart.upload.UploadContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("default-upload-task")
public class DefaultUploadTask implements UploadTask {

    @Override
    public void executePre (UploadContext context) {
        //to fix sonar issue
    }

    @Override
    public void executePost(UploadContext context) {
        //to fix sonar issue
    }

    @Override
    public void executePreRecord (UploadContext context) {
        //to fix sonar issue
    }

    @Override
    public void executePostRecord(UploadContext context) {
        //to fix sonar issue
    }

    @Override
    public void onDownloadFormat(UploadConfig config, List<String> additionalColumns) {
        //to fix sonar issue
    }

    @Override
    public void executeRecord(UploadContext context) {
        String key = String.format("query-builder-%s", context.getUnderlyingDb().getJdbcDriverPropertyValue());
        DbSpecficQueryBuilder qBuilder = ImportIntegrationTask.DB_SPECIFIC_QUERY_BUILDERS.getOrDefault(key, null);
        String query = qBuilder.bulkUpdate(context.getUploadConfig(), context.getUploadRecords());
        context.getUnderlyingDb().executeQueryWithJdbc(query);
    }
}
