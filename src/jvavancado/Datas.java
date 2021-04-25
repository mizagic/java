package jvavancado;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * versao 1.0
 *
 * @autor Cristiano Silveira
 */
public abstract class Datas {

    public static void main(String[] args) {
Calendar colombia = new GregorianCalendar(TimeZone.getTimeZone("America/Bogota"));

        Calendar brasil = Calendar.getInstance();
        colombia.setTimeInMillis(brasil.getTimeInMillis());
        int hora = colombia.get(Calendar.HOUR);
        int minuto = colombia.get(Calendar.MINUTE);
        int segundo = colombia.get(Calendar.SECOND);
        System.out.println(hora + ":" + minuto + ":" + segundo);
}

    public static Object[] getDiaMesAnoInt(Date data) {
        String sData = Formatar("dd/MM/yyyy", data);
        int dia = Integer.parseInt(sData.substring(0, 2));
        int mes = Integer.parseInt(sData.substring(3, 5));
        int ano = Integer.parseInt(sData.substring(6, 10));
        return new Object[]{dia, mes, ano};
    }

    /**
     *
     * @param dateStart
     * @param dateStop
     * @return days, hours, minutes, seconds.
     */
    public static Integer[] subtrairDatas(String dateStart, String dateStop) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);

            //in milliseconds
            Long diff = d2.getTime() - d1.getTime();

            Long diffSeconds = diff / 1000 % 60;
            Long diffMinutes = diff / (60 * 1000) % 60;
            Long diffHours = diff / (60 * 60 * 1000) % 24;
            Long diffDays = diff / (24 * 60 * 60 * 1000);

            return new Integer[]{diffDays.intValue(), diffHours.intValue(), diffMinutes.intValue(), diffSeconds.intValue()};
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date addHoras(Date data, int horas) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(data);
        gc.add(Calendar.MINUTE, horas);
        return gc.getTime();
    }

    /**
     *
     * @param mascara mascara tipo yyyy-MM-dd hh:mm:ss
     * @param data uma variavel data
     * @return retorna uma string com a mascara data formatada
     */
    public static String Formatar(String mascara, Date data) {
        if (data == null) {
            return "";
        }
        Format formato = new SimpleDateFormat(mascara);
        return formato.format(data.getTime());
    }

    public static String Formatar(String mascara, String data) {
        if (data == null) {
            return "";
        }
        Format formato = new SimpleDateFormat(mascara);
        return formato.format(stringToDate(data).getTime());
    }

    /**
     *
     * @param dtInicio
     * @param dtFim
     * @return retorna numero de dias de diferenca
     */
    public static double subtraiDatas(Calendar dtInicio, Calendar dtFim) {
        // Calcula a diferença entre hoje e da data de inicio
        long diferenca = dtFim.getTimeInMillis()
                - dtInicio.getTimeInMillis();

        // Quantidade de milissegundos em um dia
//        int tempoDia = 1000 * 60 * 60 * 24;
        int tempoDia = 1000;

        double diasDiferenca = diferenca / tempoDia;
        //diasDiferenca = diasDiferenca * 60;
        return diasDiferenca;
    }

    /**
     *
     * @param mascara mascara tipo yyyy-MM-dd hh:mm:ss
     * @param data uma variavel data
     * @return retorna uma string com a mascara data formatada
     */
    public static String Formatar(String mascara, Timestamp data) {
        if (data == null) {
            return "";
        }
        Format formato = new SimpleDateFormat(mascara);
        return formato.format(data.getTime());
    }

    /**
     * Adiciona um determinado numero de dias a uma Calendar
     *
     * @param calendar instancia de Calendar
     * @param dias numero de dias a adicionar
     * @return retorna um Calendar com os dias somados
     */
    public static Calendar addDias(Calendar calendar, int dias) {
        calendar.add(Calendar.DAY_OF_MONTH, dias);
        return calendar;
    }

    /**
     * Adiciona um determinado numero de dias a uma String
     *
     * @param data String com uma data valida
     * @param dias numero de dias a adicionar
     * @return retorna uma string com os dias somados
     */
    public static String addDias(String data, int dias) {
        Calendar calendar = stringToCalendar(data);
        calendar = addDias(calendar, dias);

        String dataStr = Formatar("dd/MM/yyyy", calendar.getTime());
        return dataStr;
    }

    /**
     * Adiciona um determinado numero de dias a uma String
     *
     * @param data String com uma data valida
     * @param dias numero de dias a adicionar
     * @return retorna uma string com os dias somados
     */
    public static Date addDias(Date data, int dias) {
        Calendar calendar = getDataAtualCalendar();
        calendar.setTime(data);
        calendar = addDias(calendar, dias);
        return calendar.getTime();
    }

    /**
     * Verifica se a data é valida ou nao
     *
     * @param dateStr data a ser validada
     * @return retorna true ou false
     */
    public static boolean validarData(String dateStr) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        //definindo que se mesmo que a formatacao esteja certa ams a data errada, da false
        df.setLenient(false);
        Calendar cal = new GregorianCalendar();
        try {
            // gerando o calendar
            cal.setTime(df.parse(dateStr));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Data invalida!!");
            return false;
        }

        // separando os dados da string para comparacao e validacao   
        String[] data = dateStr.split("/");
        String dia = data[0];
        String mes = data[1];
        String ano = data[2];

        // testando se hah discrepancia entre a data que foi   
        // inserida no caledar e a data que foi passada como   
        // string. se houver diferenca, a data passada era   
        // invalida   
        if ((new Integer(dia)).intValue() != (new Integer(cal.get(Calendar.DAY_OF_MONTH))).intValue()) {
            // dia nao casou   
            return (false);
        } else if ((new Integer(mes)).intValue() != (new Integer(cal.get(Calendar.MONTH) + 1)).intValue()) {
            // mes nao casou   
            return (false);
        } else if ((new Integer(ano)).intValue() != (new Integer(cal.get(Calendar.YEAR))).intValue()) {
            // ano nao casou   
            return (false);
        }

        return (true);
    }

    public static String getDataAtualString() {
        return Formatar("dd/MM/yyyy", getDataAtualDate());
    }

    public static String getDataAtualString(String mascara) {
        return Formatar(mascara, getDataAtualDate());
    }

    public static String getDataHoraAtualString() {
        return Formatar("dd/MM/yyyy HH:mm:ss", getDataAtualDate());
    }

    /**
     *
     * @return uma instancia de Calendar com a data atual do computador
     */
    public static Calendar getDataAtualCalendar() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }

    public static Timestamp getDataAtualTimeStamp() {
        return new Timestamp(getDataAtualCalendar().getTimeInMillis());
    }

    public static Date getDataAtualDate() {
        return new Date(getDataAtualCalendar().getTimeInMillis());
    }

    public static Date getDataAtualDateHoraZero() {
        Timestamp ts = getDataAtualTimeStampHoraZero();
        return timeStampToDate(ts);
    }

    public static Timestamp getDataAtualTimeStampHoraZero() {
        return objectToTimeStamp(Formatar("dd/MM/yyyy", getDataAtualCalendar().getTime()));
    }

    public static java.sql.Date getDataAtualSqlDate() {
        return stringToSqlDate(getDataAtualString());
    }

    public static java.sql.Date dateToSqlDate(Date data) {
        return stringToSqlDate(Formatar("dd/MM/yyyy", data));
    }

    public static XMLGregorianCalendar stringToXMLGregCal(String data) throws DatatypeConfigurationException {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(stringToDate(data));
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
    }

    public static XMLGregorianCalendar dateToXMLGregCal(Date data) throws DatatypeConfigurationException {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(data);
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
    }

    public static Calendar stringToCalendar(String data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(stringToDate(data));
        return cal;
    }

    public static Date stringToDate(String data) {
        try {
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (Date) formatter.parse(data);
            return date;
        } catch (ParseException e) {
            Logger.getLogger(Datas.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return null;
    }

    public static Date stringToDateTime(String data) {
        try {
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            date = (Date) formatter.parse(data);
            return date;
        } catch (ParseException e) {
            Logger.getLogger(Datas.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return null;
    }

    public static java.sql.Date stringToSqlDate(String data) {
        return new java.sql.Date(stringToCalendar(data).getTimeInMillis());
    }

    public static Timestamp objectToTimeStamp(Object data) {
        if (data instanceof String) {
            SimpleDateFormat sdf;
            if (data.toString().length() == 19) {
                sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            } else if (data.toString().length() == 28) {
                System.out.println(data.toString());
                Date d = new Date(data.toString());
                data = stringToCalendar(data.toString());
                sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            } else {
                sdf = new SimpleDateFormat("dd/MM/yyyy");
            }
            Date date = null;
            try {
                date = sdf.parse(data.toString());
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            return new java.sql.Timestamp(date.getTime());
        }
        return null;
    }

    public static Timestamp dateToTimeStamp(Date data) {
        return objectToTimeStamp(Formatar("dd/MM/yyyy HH:mm:ss", data));
    }

    public static Date timeStampToDate(Timestamp timeStamp) {
        return new Date(timeStamp.getTime());
    }

    public static String getDiaSemanaExtenso(Calendar data) {
        switch (data.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:
                return "Domingo";
            case Calendar.MONDAY:
                return "Segunda Feira";
            case Calendar.TUESDAY:
                return "Terça Feira";
            case Calendar.WEDNESDAY:
                return "Quarta Feira";
            case Calendar.THURSDAY:
                return "Quinta Feira";
            case Calendar.FRIDAY:
                return "Sexta Feira";
            case Calendar.SATURDAY:
                return "Sábado";
        }
        return null;
    }
}
