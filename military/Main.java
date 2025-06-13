

import military.enums.Corps;
import military.interfaces.*;
import military.interfaces.entities.*;

import java.util.*;

public class Main {
    private static Map<Integer, Private> soldiersById = new LinkedHashMap<>();
    private static Map<Integer, Spy> spyMap = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        while (!input.equals("End")) {

            Private soldier = createSoldier(input);
            if (soldier != null) {


                soldiersById.put(soldier.getId(), soldier);

            }
            input = scanner.nextLine();
        }
        for (Soldier value : soldiersById.values()) {
            System.out.println(value.toString());
        }
        for (Spy value : spyMap.values()) {
            System.out.println(value.toString());
        }

    }


    private static Private createSoldier(String input) {
        String[] split1 = input.split(" ");
        String type = split1[0];
        Private aprivate = null;
        switch (type) {
            case "Private":
                aprivate = new PrivateImpl(Integer.parseInt(split1[1]), split1[2],
                        split1[3], Double.parseDouble(split1[4]));

                break;
            case "LieutenantGeneral":
                aprivate = createLieutenantGeneral(split1);

                break;
            case "Engineer":
                aprivate = createEngineer(split1);

                break;
            case "Commando":
                aprivate = createCommando(split1);

                break;
            case "Spy":
                spyMap.put(Integer.parseInt(split1[1]), new SpyImpl(Integer.parseInt(split1[1]),
                        split1[2],
                        split1[3],
                        split1[4]
                ));


                break;

            default:
                aprivate = null;
                break;


        }
        return aprivate;
    }

    private static Private createCommando(String[] split) {
        String corbs = split[5];
        if (corbs.equals("Airforces") || corbs.equals("Marines")) {

            Commando commando = new CommandoImpl(Integer.parseInt(split[1]), split[2],
                    split[3], Double.parseDouble(split[4]), Corps.valueOf(corbs.toUpperCase()));
            for (int i = 6; i < split.length; i += 2) {
                String codeName = split[i];
                String state = split[i + 1];
                if (!state.equals("inProgress") && !state.equals("finished")) {
                    continue;

                }
                Mission mission = new MissionImpl(codeName, state.equals("inProgress") ? MissionImpl.Status.IN_PROGRESS :
                        MissionImpl.Status.FINISHED);
                commando.addMission(mission);


            }
            return commando;
        }
        return null;
    }

    private static Private createEngineer(String[] split) {
        String corps = split[5];
        if (corps.equals("Airforces") || corps.equals("Marines")) {

            Engineer engineer = new EngineerImpl(Integer.parseInt(split[1]), split[2],
                    split[3], Double.parseDouble(split[4]), Corps.valueOf(corps.toUpperCase()));
            for (int i = 6; i < split.length; i += 2) {
                String partName = split[i];
                int hoursWorked = Integer.parseInt(split[i + 1]);
                Repair repair = new RepairImpl(partName, hoursWorked);
                engineer.addRepair(repair);

            }
            return engineer;
        }
        return null;
    }

    private static Private createLieutenantGeneral(String[] split) {
        LieutenantGeneral lieutenantGeneral = new LieutenantGeneralImpl(Integer.parseInt(split[1]), split[2],
                split[3], Double.parseDouble(split[4]));
        for (int i = 5; i < split.length; i++) {
            lieutenantGeneral.addPrivate(soldiersById.get(Integer.parseInt(split[i])));

        }

        return lieutenantGeneral;
    }


}
