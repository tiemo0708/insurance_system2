package src.system.accident;

import java.util.ArrayList;
import java.util.List;

public class AccidentListImpl implements AccidentList {

    private ArrayList<Accident> accidentList;

    public AccidentListImpl() {
        this.accidentList = new ArrayList<>();
    }

    @Override
    public void add(Accident accident) {
        accidentList.add(accident);
    }

    @Override
    public void delete(long accidentId) {
        accidentList.removeIf(accident -> accident.accidentId == accidentId);
    }

    @Override
    public Accident get(long accidentId) {
        return accidentList.stream()
                .filter(accident -> accident.accidentId == accidentId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public ArrayList<Accident> get() {
        return accidentList;
    }

    @Override
    public Accident getReportedAccident(long accidentId) {
        ArrayList<Accident> reportedAccitentList = new ArrayList<>();
        for (Accident accident : accidentList) {
            if (accident.status.equals("접수됨")) {
                reportedAccitentList.add(accident);
            }
        }

        return reportedAccitentList.stream().
                filter(accident -> accident.accidentId == accidentId).
                findFirst().orElse(null);
    }

    @Override
    public ArrayList<Accident> getReportedAccidentList() {
        ArrayList<Accident> reportedAccitentList = new ArrayList<>();

        for (Accident accident : accidentList) {
            if (accident.status.equals("접수됨")) {
                reportedAccitentList.add(accident);
            }
        }
        return reportedAccitentList;
    }

    @Override
    public void update(long accidentId, Accident updatedAccident) {
        for (int i = 0; i < accidentList.size(); i++) {
            if (accidentList.get(i).accidentId == accidentId) {
                accidentList.set(i, updatedAccident);
                return;
            }
        }
    }
}
