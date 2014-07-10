AsyncExamples
=============

Examples of how to get data from network in the background. 

I'd like to start a Madison Android User Group and have started to put together this project to sample the various ways to process in the backgroud. Or at least make a nice blog post about it.

- Runnable handled on a thread 
- Using AsyncTask (config change issues)
- Using AsyncTaskLoader (Puts task outside of Activity/Fragment and allows you to re-attach)
- Using non-UI fragment with setRetainInstance(true) to emulate what AsyncTaskLoader does
- Use Square's Otto to publish/subsribe to an event bus
- Use a ServiceIntent that broadcasts the result to the fragment
 

