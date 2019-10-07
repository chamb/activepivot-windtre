# activepivot-jdbc for the MNP database

## Getting everything

Clone this repository to cdba3.

## Compiling

```
./mvnBuild.sh
```

If you edit the properties, you will need to recompile your project.

You will not be able to build out of cdba3, as some dependencies are
contained in cdba3.

## Executing

```
./run.sh
```
ActivePivot takes around 6min to load the 12 million rows of the MNP table.

This line
```
2019-10-07 15:24:18.983  INFO 63360 --- [vent-dispatcher] c.a.h.m.ILoggingHealthEventHandler       : [datastore, transaction] INFO 2019-10-07T13:24:18.978Z uptime=10416ms com.qfs.store.transaction.impl.TransactionManager.startTransactionNoRevert:528
```
shows the data is being loaded. When it finishes, a table summarizing the
amount of data loaded is printed, along with these lines:
```
2019-10-07 15:30:35.164  INFO 63360 --- [vent-dispatcher] c.a.h.m.ILoggingHealthEventHandler       : [datastore, transaction] INFO 2019-10-07T13:30:35.164Z uptime=386602ms com.qfs.store.transaction.impl.TransactionManager.commitTransaction:1012 thread=main thread_id=1 event_type=DatastoreTransactionCommitted Transaction Committed  transaction_id=1 transaction_duration=376187ms commit_duration=46ms
2019-10-07 15:30:35.164  INFO 63360 --- [           main] DataLoadingConfig                        : Data load completed in 376188ms
```
Once the data is loaded, you can connect to ActiveUI and run queries.

## Running queries

In your web browser, connect to 92.43.249.205:19210/
Username is "admin", password is "admin".

In the widget tab, drag and drop a "pivot table" to the main window.

In the content editor tab, drag and drop fields to rows and columns to
perform queries. You can also add filters.

## Editing the project

Relevant files:
* `src/main/resources/application.properties` defines the database connection
  properties, and the port on which active-ui is available.
* `src/main/java/com/activeviam/sandbox/` contains all the code. In particular,
  `generator/Mnp.java`,
  `cfg/datastore/DatastoreDescriptionConfig`, and
  `cfg/pivot/ActivePivotManagerConfig` define the data model (fields and data
  types of the MNP store).
