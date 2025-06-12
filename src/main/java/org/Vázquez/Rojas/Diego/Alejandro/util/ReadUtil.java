package org.Vázquez.Rojas.Diego.Alejandro.util;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ReadUtil
{
    private Scanner scanner;
    private static ReadUtil readUtil;

    private ReadUtil()
    {
        scanner = new Scanner( System.in );
    }

    public Scanner getScanner()
    {
        return scanner;
    }

    public static ReadUtil getInstance( )
    {
        if(readUtil==null)
        {
            readUtil = new ReadUtil();
        }
        return readUtil;
    }

    public static String read( )
    {
        return getInstance( ).getScanner( ).nextLine();
    }

    public static Integer readInt( )
    {
        String valor = null;
        boolean flag = true;
        Integer aux = null;

        while (flag)
        {
            valor = read();
            if (valor != null && !valor.isEmpty())
            {
                try
                {
                    aux = Integer.valueOf(valor);
                    if (aux != null)
                    {
                        return aux;
                    }
                }
                catch (Exception e)
                {
                }
            }
            System.out.println( "Valor incorrecto, intentelo nuevamente" );
        }
        return null;
    }

    public static Integer string2Integer( String valor )
    {
        try
        {
            return Integer.valueOf(valor);
        }
        catch (Exception e)
        {
        }
        return null;
    }

    public static Time readTime() {
        while (true) {
            String valor = read();
            try {
                return Time.valueOf(valor);
            } catch (IllegalArgumentException e) {
                System.out.println("Formato de hora inválido. Use HH:mm:ss");
            }
        }
    }
    public static Float readFloat()
    {
        String valor=null;
        boolean flag=true;
        float aux=0;

        while (flag)
        {
            valor=read();
            if (valor!=null && !valor.isEmpty())
            {
                try
                {
                    aux=Float.valueOf(valor);
                    return aux;
                }
                catch (Exception e)
                {
                    System.out.println("Número inválido intente de nuevo");
                }
            }
            System.out.println("Valor incorrecto, intente de nuevo");
        }
        return null;
    }
    public static LocalDate readLocalDate() {
        LocalDate fecha = null;

        while (fecha == null) {
            System.out.print("Ingrese la fecha (formato aaaa-MM-dd): ");
            String input = getInstance().getScanner().nextLine();
            try {
                fecha = LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Intente de nuevo.");
            }
        }
        return fecha;
    }
}