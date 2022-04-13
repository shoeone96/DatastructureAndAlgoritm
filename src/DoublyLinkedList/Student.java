package DoublyLinkedList;

class Student {
    private int idNumber;
    private String name;

    Student(String name, int idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return   name + " " + idNumber;
    }

    public void setIdNumber(int number) {
        this.idNumber = number;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
