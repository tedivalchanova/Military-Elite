package military.interfaces;

import java.util.Collection;

public interface Commando  extends Private{
     void addMission(Mission mission);
     Collection<Mission>getMissions();
}
