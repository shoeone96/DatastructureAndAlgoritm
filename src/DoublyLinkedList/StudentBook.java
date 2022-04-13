package DoublyLinkedList;


import java.util.Scanner;

public class StudentBook {
    public static void main(String args[]) {
        StudentBook studentBook = new StudentBook();
        SList<Node<Student>> studentList = new SList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("원하시는 서비스의 번호를 입력해주세요");
            System.out.println("1. 학생 추가, 2. 전 학생 출력, 3. 시스템 종료");
            int input = scanner.nextInt();
            if (input == 1) {
                System.out.println("이름과 번호를 입력하세요");
                String name = scanner.next();
                int id = scanner.nextInt();
                Student student = new Student(name, id);
                studentBook.insertStudent(studentList, student);
            } else if (input == 2) {
                studentBook.printStudent(studentList);
            } else {
                System.out.println("프로그램을 종료합니다.");
            }
            if (input == 3) break;
            System.out.println("------------------------");
        }
        scanner.close();

    }

    public void insertStudent(SList<Node<Student>> studentList, Student student) {

        Node<Student> newNode = new Node<>(student, null, null);
        Node p = studentList.head;
        int point = 1;
        for (int i = 0; i < studentList.getSize(); i++) {
            if (p.getNext().getItem().toString().equals(student.toString())) {
                studentList.deleteAfter(p.getNext());
                point = 0;
                break;
            }
            p = p.getNext();
        }
        if (point == 1) studentList.insertFront(newNode);
    }

    public void printStudent(SList studentList) {
        Node p = studentList.tail;
        for (int i = 0; i < studentList.getSize(); i++) {
            System.out.println(p.getBefore().toString());
            p = p.getBefore();
        }
    }
}

