package military.interfaces.entities;

import military.interfaces.Mission;

public class MissionImpl implements Mission {


    public   enum Status{
        IN_PROGRESS,FINISHED



    }
    private String codeName;
    private Status status;

    public MissionImpl(String codeName,Status status){
        this.codeName=codeName;
        this.status=status;
    }
    @Override
    public void completeMission() {
this.status=Status.FINISHED;
    }
}
