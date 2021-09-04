package serverwofacade;

public class MyFacade {
    private static MyFacade myFacadeOBj = null;
    private MyFacade() {}
    public static MyFacade getMyFacadeObj(){
        if (myFacadeOBj == null) {
            myFacadeOBj = new MyFacade();
        }
        return myFacadeOBj;
    }
    public void start(){
    ScheduleServer scheduleServer = new ScheduleServer();
    scheduleServer.startBooting();
	scheduleServer.readSystemConfigFile();
	scheduleServer.init();
	scheduleServer.initializeContext();
	scheduleServer.initializeListeners();
	scheduleServer.createSystemObjects();
    System.out.println("Start working......");
    }
    public void end(){
    ScheduleServer scheduleServer = new ScheduleServer();
    System.out.println("After work done.........");
    scheduleServer.releaseProcesses();
    scheduleServer.destory();
    scheduleServer.destroySystemObjects();
    scheduleServer.destoryListeners();
    scheduleServer.destoryContext();
    scheduleServer.shutdown();
    }    
    
}
