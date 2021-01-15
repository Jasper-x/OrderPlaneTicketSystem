package cn.edu.hcnu.ui;

import cn.edu.hcnu.bean.Flight;
import cn.edu.hcnu.bll.IFlightService;
import cn.edu.hcnu.bll.impl.FlightServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//���ܼ�������
        while (true) {
            System.out.println("��������Ӧ�����ֽ��в�����");

            System.out.println("��1��¼�뺽����Ϣ");
            System.out.println("��2����ʾ���к�����Ϣ");
            System.out.println("��3����ѯ������Ϣ");
            System.out.println("��4����ƱԤ��");
            System.out.println("��5����Ʊ�˶�");
            System.out.println("��6���Ƴ�ϵͳ");

            int choice = sc.nextInt();

            if (choice == 1) {
                String id = UUID.randomUUID().toString().replace("-", "");

                System.out.print("�����뺽���ţ�");
                String flightId = sc.next();
                System.out.print("��������ͣ�");
                String planeType = sc.next();
                System.out.print("��������λ����");
                int currentSeatsNum = sc.nextInt();
                System.out.print("��������ɻ�����");
                String departureAirPort = sc.next();
                System.out.print("������Ŀ�Ļ�����");
                String destinationAirPort = sc.next();
                System.out.print("���������ʱ�䣺");
                String departureTime = sc.next();

                Flight flight = new Flight(id, flightId, planeType, currentSeatsNum,
                        departureAirPort, destinationAirPort, departureTime);

                IFlightService iFlightService = new FlightServiceImpl();
                try {
                    iFlightService.insertFlight(flight);
                } catch (SQLException e) {
                    String errorMessage = e.getMessage();
                    if (errorMessage.startsWith("ORA-12899")) {
                        //ORA-12899: value too large for column "OPTS"."FLIGHT"."ID" (actual: 32, maximum: 30)
                        // ��ָ��ģʽ���ַ�������
                        String pattern = "(\\w+-\\d{5}):(\\s\\w+)+\\s(\"\\w+\")\\.(\"\\w+\")\\.(\"\\w+\")";
                        // ���� Pattern ����
                        Pattern r = Pattern.compile(pattern);
                        // ���ڴ��� matcher ����
                        Matcher m = r.matcher(errorMessage);
                        if (m.find()) {
                            String tableName = m.group(4);
                            String columnName = m.group(5);
                            System.out.println(tableName + "���" + columnName + "��һ�е�ֵ��������ϸ��飬��ϵ����Ա");
                        } else {
                            System.out.println("NO MATCH");
                        }
                    }
                }
            } else if (choice == 2) {
                IFlightService iFlightService = new FlightServiceImpl();
                try {
                    Set<Flight> allFlights = iFlightService.getAllFlights();
                    /*
                    Set�ı�����Ҫ�õ�������
                     */
                    for (Flight flight : allFlights) {
                        System.out.println(flight);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (choice == 3) {
                System.out.println("������Ӧ�ı��ѡ����Ҫ��ѯ����ķ�ʽ��");
                System.out.println("1�������ʱ���ѯ");
                System.out.println("2����������Ϣ��ѯ");
                System.out.println("3������ɵڲ�ѯ");
                System.out.println("4����Ŀ�ĵز�ѯ");
                int choose = sc.nextInt();
                if (choose == 1) {
                    System.out.println("���������ʱ�䣺");
                    String departureTime = sc.next();
                    IFlightService iFlightService = new FlightServiceImpl();
                    try {
                        Flight flight = iFlightService.getFlightByDepartureTime(departureTime);
                        if (flight != null) {
                            System.out.println("��ѯ�����" + flight);
                        } else {
                            System.out.println("û�в�ѯ����ʱ��ĺ���");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}