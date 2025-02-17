//circularqueue in array
#include<stdio.h>
#include<stdlib.h>

int front = -1, rear = -1, *queue, item, i, size;

int enqueue();
int dequeue();
int display();
int search();

int main() {
    int option;
    printf("Enter the size of the circular queue: ");
    scanf("%d", &size);

    queue = (int*) malloc(size * sizeof(int));

    if (queue == NULL) {
        printf("Memory allocation failed. Exiting program.");
        exit(1);
    }

    while(1) {
        printf("\n1.Enqueue\n2.Dequeue\n3.Display\n4.Search\n5.Exit");
        printf("\nSelect Operation : ");
        scanf("%d", &option);
        switch(option) {
            case 1:
                enqueue();
                break;
            case 2:
                dequeue();
                break;
            case 3:
                display();
                break;
            case 4:
                search();
                break;
            case 5:
                free(queue);
                exit(0);
            default:
                printf("Invalid Option\n");
                break;
        }
    }
}


int enqueue() {
    if (front == -1 && rear == -1) {
        front = 0;
        rear = 0;
        printf("Enter Element to Insert : ");
        scanf("%d", &item);
        queue[front] = item;
    } else if (((rear + 1) % size) == front) {
        printf("\nQueue is Full");
    } else {
        printf("Enter Element to Insert : ");
        scanf("%d", &item);
        rear = (rear + 1) % size;
        queue[rear] = item;
    }
}



int dequeue() {
    if (front == -1 && rear == -1) {
        printf("\nQueue Underflow");
    } else if (front == rear) {
        printf("Deleted Element is %d", queue[front]);
        front = rear = -1;
    } else {
        printf("Deleted Element %d", queue[front]);
        front = (front + 1) % size;
    }
}



int display() {
    if (front == -1 && rear == -1) {
        printf("\nNothing to Display");
    } else {
        printf("\nElements are: ");
        for (i = front; i != rear; i = (i + 1) % size) {
            printf("%d ", queue[i]);
        }
        printf(" %d ", queue[i]);
    }
}




int search() {
    if (front == -1 && rear == -1) {
        printf("\nQueue is Empty");
    } else {
        int searchItem, found = 0;
        printf("Enter Element to Search: ");
        scanf("%d", &searchItem);
        for (i = front; i != rear; i = (i + 1) % size) {
            // if (queue[i] == searchItem) {
            //     found = 1;
            //     break;
            // }
        }
        if (queue[i] == searchItem) {
            found = 1;
        }
        if (found) {
            printf("Element %d found in the queue\n", searchItem);
        } else {
            printf("Element %d not found in the queue\n", searchItem);
        }
    }
}
