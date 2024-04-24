package Pertemuan10.Tugas.src;

public class Queue26 {
    Pembeli29[] antrian;
    int front;
    int rear;
    int size;
    int max;

    public Queue26(int n) {
        max = n;
        antrian = new Pembeli29[max];
        size = 0;
        front = rear = -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void enqueue(Pembeli29 antri) {
        if (!isFull()) {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % max;
            }
            antrian[rear] = antri;
            size++;
        } else {
            System.out.println("Antrian penuh");
        }
    }

    public Pembeli29 dequeue() {
        Pembeli29 temp = null;
        if (!isEmpty()) {
            temp = antrian[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % max;
            }
            size--;
        } else {
            System.out.println("Antrian kosong");
        }
        return temp;
    }

    public void print() {
        if (!isEmpty()) {
            int i = front;
            while (i != rear) {
                System.out.println("Nama: " + antrian[i].nama + ", No HP: " + antrian[i].noHP);
                i = (i + 1) % max;
            }
            System.out.println("Nama: " + antrian[i].nama + ", No HP: " + antrian[i].noHP);
        } else {
            System.out.println("Antrian kosong");
        }
    }

    public void peek() {
        if (!isEmpty()) {
            System.out.println("Pembeli paling depan: " + antrian[front].nama + ", No HP: " + antrian[front].noHP);
        } else {
            System.out.println("Antrian kosong");
        }
    }

    public void peekRear() {
        if (!isEmpty()) {
            System.out.println("Pembeli paling belakang: " + antrian[rear].nama + ", No HP: " + antrian[rear].noHP);
        } else {
            System.out.println("Antrian kosong");
        }
    }

    public void peekPosition(String nama) {
        if (!isEmpty()) {
            int i = front;
            int position = 1;
            while (i != rear) {
                if (antrian[i].nama.equals(nama)) {
                    System.out.println("Pembeli " + nama + " berada di posisi antrian ke-" + position);
                    return;
                }
                position++;
                i = (i + 1) % max;
            }
            if (antrian[i].nama.equals(nama)) {
                System.out.println("Pembeli " + nama + " berada di posisi antrian ke-" + position);
            } else {
                System.out.println("Pembeli " + nama + " tidak ditemukan dalam antrian");
            }
        } else {
            System.out.println("Antrian kosong");
        }
    }

    public void daftarPembeli() {
        if (!isEmpty()) {
            System.out.println("Daftar Pembeli:");
            int i = front;
            while (i != rear) {
                System.out.println("Nama: " + antrian[i].nama + ", No HP: " + antrian[i].noHP);
                i = (i + 1) % max;
            }
            System.out.println("Nama: " + antrian[i].nama + ", No HP: " + antrian[i].noHP);
        } else {
            System.out.println("Antrian kosong");
        }
    }
}