package JAVA_Test;

import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;

import static java.lang.Integer.parseInt;

public class ProjectBean extends ProjectGenericBean {

    private static final String toStringSeparator = " - ";

    private String titre;
    public int numero;
    private Date dateDebut;
    private Date dateFin;

    public ProjectBean(String titre, int numero, Date dateDebut, Date dateFin) {
        this.titre = titre;
        this.numero = numero;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }


    public String toString() {
        return new StringBuilder().append(this.numero).append(toStringSeparator)
                .append(StringUtils.isEmpty(this.titre) ? "-?-" : this.titre).toString();
    }

    @Override
    public Period getDuration() {
        if (this.dateDebut != null && this.dateFin != null) {
            Calendar startDate = new GregorianCalendar();
            startDate.setTime(this.dateDebut);
            Calendar endDate = new GregorianCalendar();
            endDate.setTime(this.dateFin);

            LocalDate oldDate = LocalDate.of(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH),
                    startDate.get(Calendar.DAY_OF_MONTH));
            LocalDate newDate = LocalDate.of(endDate.get(Calendar.YEAR), endDate.get(Calendar.MONTH),
                    endDate.get(Calendar.DAY_OF_MONTH));
            return Period.between(oldDate, newDate);
        }
        return Period.ZERO;
    }

    @Override
    public String getDurationToString() {

        return this.getDuration().getYears() + "Year(s)" + toStringSeparator + this.getDuration().getMonths()
                + "Month(s)" + toStringSeparator + this.getDuration().getDays() + "Day(s)";
    }

    public String getDurationToString(String flag) {
        Period duration = getDuration();
        String durationByPeriod = "";

        switch (flag) {
            case "YEAR":
                String yearsDuration = String.valueOf(duration.getYears());
                durationByPeriod += yearsDuration + "year" + (parseInt(yearsDuration) > 1 ? "s" : "") + ".";
                break;
            case "MONTH":
                String monthsDuration = String.valueOf(duration.getMonths());
                durationByPeriod += monthsDuration + "year" + (parseInt(monthsDuration) > 1 ? "s" : "") + ".";
                break;
            case "DAY":
                String daysDuration = String.valueOf(duration.getDays());
                durationByPeriod += daysDuration + "year" + (parseInt(daysDuration) > 1 ? "s" : "") + ".";
                break;
            default:
                durationByPeriod = "Incorrect period format.";
                break;
        }

        return durationByPeriod;
    }
}
