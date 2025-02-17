//1 method
  #include<stdio.h>
#include<stdlib.h>

struct node
{
        struct node * prev;
        int data;
        struct node * next;
};

struct node * head=NULL;


struct node * createnode(int item)
{
        struct node * newnode = (struct node*)malloc(sizeof(struct node));
        newnode->prev = NULL;
        newnode->data = item;
        newnode->next = NULL;
        return newnode;
}

void insertAtFront(int item)
{
        struct node * newnode = createnode(item);
        newnode->next = head;
        head = newnode;
        printf("Item Inserted!\n");
}

void insertAtPosition(int item,int position)
{
        if(position<1)
        {
                printf("Position cannot be <1.\n");
                return;
        }
        if(position == 1)
        {
                insertAtFront(item);
                return;
        }

        struct node * newnode = createnode(item);
        struct node * temp = head;

        for (int i = 1; i < position - 1 && temp != NULL; i++)
        {
                temp = temp->next;
        }
        if (temp == NULL)
        {
                printf("Position Not available.\n");
                free(newnode);
        }
        else
        {
                newnode->next = temp->next;
                newnode->prev = temp;
                temp->next = newnode;
                temp->next->prev = newnode;
                printf("Item Inserted at %d position!\n",position);
        }
}



void insertAtBack(int item)
{
        struct node * newnode = createnode(item);
        if(head == NULL)
        {
                head = newnode;
        }
        struct node* temp = head;
        while(temp->next != NULL)
                temp = temp->next;
                temp->next = newnode;
                newnode->prev = temp;
                printf("Item Inserted!\n");
}

void deleteFromFront()
{
    if(head == NULL)
    {
        printf("List is empty!\n");
        return;
    }

    struct node* temp = head;
    head = temp->next;
   
    if (head != NULL)
    {
        head->prev = NULL;
    }

    free(temp);
    printf("Item Deleted!\n");
}


void deleteFromPosition(int position)
{
        if (head == NULL)
        {
                printf("List is empty.\n");
                return;
        }
        if (position < 1)
        {
                printf("Position cannot be <1.\n");
                return;
        }
        if (position == 1)
        {
                deleteFromFront();
                return;
        }

        struct node* temp = head;
        struct node* loc = NULL;

        for (int i = 1; i < position; i++)
        {
                loc = temp;
                temp = temp->next;
        }
        if (temp == NULL)
        {
                printf("Position Not available.\n");
        }
        else
        {
                loc->next = temp->next;
                temp->next->prev = loc;
                free(temp);
                printf("Item Deleted!\n");
        }
}


void deleteFromBack()
{
        if(head == NULL)
        {
                printf("List is empty.\n");
                return;
        }

        struct node* temp = head;
        struct node* loc = NULL;

        if(temp->next == NULL)
        {
                free(temp);
                head = NULL;
                return;
        }

        while(temp->next != NULL)
        {
                loc=temp;
                temp = temp->next;
        }
        loc->next = NULL;
        free(temp);
        printf("Item Deleted!\n");
}


void display()
{
        struct node* temp = head;
        if(temp == NULL)
        {
                printf("List is empty.\n");
                return;
        }
        printf("Head -> ");
        while(temp != NULL)
        {
                printf("%d -> ", temp->data);
                temp = temp->next;
        }
        printf("NULL\n");
}

int main()
{
        int choice,item,position;
        do{
                printf("1.Insert at front\n2.Insert at position\n3.Insert at back\n4.Delete from front\n5.Delete from postion\n");
                printf("6.Delete from back\n7.Display\n8.Exit\nEnter your choice :");
                scanf("%d",&choice);
                switch(choice)
                {
                        case(1):
                                printf("Enter item to insert at front :");
                                scanf("%d",&item);
                                insertAtFront(item);
                                break;
                        case(2):
                                printf("Enter item to be inserted :");
                                scanf("%d",&item);
                                printf("Enter the position :");
                                scanf("%d",&position);
                                insertAtPosition(item,position);
                                break;
                        case(3):
                                printf("Enter item to insert at back :");
                                scanf("%d",&item);
                                insertAtBack(item);
                                break;
                        case(4):
                                deleteFromFront();
                                break;
                        case(5):
                                printf("Enter the position :");
                                scanf("%d",&position);
                                deleteFromPosition(position);
                                break;
                        case(6):
                                deleteFromBack();
                                break;
                        case(7):
                                display();
                                break;
                        case(8):
                                printf("Exiting...\n");
                                break;
                        default:
                                printf("Invalid choice!Try again.\n");
                                break;
                }
        } while(choice!=8);

        return 0;
}

	//#2 method 
    #include<stdio.h>
#include<stdlib.h>

// Definition of the doubly linked list node
struct node{
    int data;
    struct node* next;
    struct node* prev;  // Previous pointer added for doubly linked list
};

struct node* head = NULL;  // Head pointer

// Function to display the list
void display(){
    if (head == NULL) {
        printf("\nList is empty\n");
        return;
    }
    struct node* temp = head;
    while (temp != NULL) {
        printf("%d\t", temp->data);
        temp = temp->next;
    }
}

// Insert at the beginning of the list
void ins_beg(int item){
    struct node* newnode = (struct node*)malloc(sizeof(struct node));
    newnode->data = item;
    newnode->next = head;
    newnode->prev = NULL;  // Previous of new node will be NULL
    
 if (head != NULL)
        head->prev = newnode;  // Update the previous of the current head
    
    head = newnode;  // Set new node as the head
   display();
}

// Insert at the end of the list
void ins_end(int item){
    struct node* newnode = (struct node*)malloc(sizeof(struct node));
    newnode->data = item;
    newnode->next = NULL;  // Since it's the last node, next will be NULL
    newnode->prev = NULL;  // Initialize previous pointer

    if (head == NULL) {
        head = newnode;  // If the list is empty, new node becomes the head
        return;
    }

    struct node* temp = head;
    while (temp->next != NULL) {
        temp = temp->next;  // Traverse to the last node
    }
    
    temp->next = newnode;  // Link the last node's next to the new node
    newnode->prev = temp;  // Link the new node's prev to the last node
    display();

}

// Insert at a specific position in the list using while loop
void ins_pos(int item, int pos){
 struct node* newnode = (struct node*)malloc(sizeof(struct node));
    newnode->data = item;

    if (pos == 1) {
        ins_beg(item);
        return;
    }

    struct node* temp = head;
    int i = 1;

    // Replaced the for loop with a while loop to traverse to (pos-1)
    while (i < pos - 1 && temp != NULL) {
        temp = temp->next;
        i++;
    }

    if (temp == NULL) {
        printf("\nPosition not found\n");
        free(newnode);
        return;
    }

    newnode->next = temp->next;  // Set new node's next to the next node of temp
    newnode->prev = temp;        // Set new node's prev to temp

     if (temp->next != NULL)  // If temp's next isn't NULL, update the next node's prev pointer
        temp->next->prev = newnode;

    temp->next = newnode;  // Set temp's next to newnode
    display();
}

// Delete the first node (head) of the list
void del_beg(){
    if (head == NULL) {
        printf("\nList is empty\n");
        return;
    }

    struct node* temp = head;
    printf("%d is deleted\n", temp->data);

    head = temp->next;  // Move head to the next node

    if (head != NULL)
        head->prev = NULL;  // Update the prev of the new head node

    free(temp);  // Free the deleted node
    display();
}

// Delete the last node of the list
void del_end(){
    if (head == NULL) {
        printf("\nList is empty\n");
        return;
}

    struct node* temp = head;

    if (temp->next == NULL) {  // If there's only one node
        printf("%d is deleted\n", temp->data);
        free(temp);
        head = NULL;
        return;
    }

    // Traverse to the last node using while loop
    while (temp->next != NULL) {
        temp = temp->next;
    }

    printf("%d is deleted\n", temp->data);
    temp->prev->next = NULL;  // Set the second-last node's next to NULL
    free(temp);  // Free the last node
    display();
}

// Delete a node at a specific position in the list using while loop
void del_pos(int pos) {
    if (head == NULL) {
        printf("\nList is empty\n");
        return;
    }

    if (pos == 1) {
        del_beg();
        return;
 }

    struct node* temp = head;
    int i = 1;
    while (i < pos && temp != NULL) {
        temp = temp->next;
        i++;
    }

    if (temp == NULL) {
        printf("\nPosition not found\n");
        return;
    }

    printf("%d is deleted\n", temp->data);

    if (temp->next != NULL)  // If it's not the last node
        temp->next->prev = temp->prev;

    if (temp->prev != NULL)  // If it's not the first node
    	temp->prev->next = temp->next;


    free(temp);  // Free the deleted node
    display();
}

// Main function with menu options
void main() {
	int ch;
    while (1) {
         printf("\n1.Insert at begining\n2.Insert at end\n3.Insert at position\n4.Delete at begining\n5.Delete at end\n6.Delete at position\n7.display\n8.exit");
        scanf("%d", &ch);
        switch (ch) {
            case 1: {
                int item;
                printf("\nEnter the element to be inserted: ");
                scanf("%d", &item);
                ins_beg(item);
                break;
            }
            case 2: {
                int item2;
                printf("\nEnter the element to be inserted: ");
                scanf("%d", &item2);
                ins_end(item2);
                break;
            }
            case 3: {
                int item3, pos2;
                printf("\nEnter the element to be inserted: ");
                scanf("%d", &item3);
                printf("\nEnter the position of element to be inserted: ");
                scanf("%d", &pos2);
                ins_pos(item3, pos2);
                break;
            }
            case 4:
                del_beg();
                break;
	    
             

            case 5:
                del_end();
                break;

            case 6: {
                int pos;
                printf("\nEnter the position of element to be deleted: ");
                scanf("%d", &pos);
                del_pos(pos);
                break;
            }
            case 7:
                display();
                break;

            case 8:
                printf("\nExiting....");
                exit(0);
                break;

            default:
                printf("\nInvalid choice!\n");
                break;
        }
    }
}

//3doubly code (easy to understand)
// Program to implement Doubly Linked List



#include<stdio.h>

#include<stdlib.h>



struct node

{

	struct node * prev;

        int data;

        struct node * next;

};



struct node * head=NULL;





struct node * createnode(int item)

{

	struct node * newnode = (struct node*)malloc(sizeof(struct node));

	newnode->prev = NULL;

	newnode->data = item;

	newnode->next = NULL;

	return newnode;

}





void insertAtFront(int item)

{

	struct node * newnode = createnode(item);

        newnode->next = head;

        head = newnode;

	printf("Item Inserted!\n");

}





void insertAtPosition(int item,int position)

{

	if(position<1)

        {

                printf("Position cannot be <1.\n");

                return;

        }

        if(position == 1)

        {

                insertAtFront(item);

                return;

        }



        struct node * newnode = createnode(item);

        struct node * temp = head;



        for (int i = 1; i < position - 1 && temp != NULL; i++)

        {

                temp = temp->next;

        }

        if (temp == NULL)

        {

                printf("Position Not available.\n");

                free(newnode);

        }

        else

	{

		newnode->next = temp->next;

		newnode->prev = temp;

		temp->next = newnode;

		temp->next->prev = newnode;

		printf("Item Inserted at %d position!\n",position);

	}

}





void insertAtBack(int item)

{

	struct node * newnode = createnode(item);

        if(head == NULL)

        {

                head = newnode;

        }

        struct node* temp = head;

        while(temp->next != NULL)

                temp = temp->next;

                temp->next = newnode;

		newnode->prev = temp;

		newnode->next=NULL;

		printf("Item Inserted!\n");

}





void deleteFromFront()

{

    if(head == NULL)

    {

        printf("List is empty!\n");

        return;

    }



    struct node* temp = head;

    head = temp->next;

    

    if (head != NULL) 

    {

        head->prev = NULL;

    }



    free(temp);

    printf("Item Deleted!\n");

}





void deleteFromPosition(int position)

{

	if (head == NULL)

        {

                printf("List is empty.\n");

                return;

        }

        if (position < 1)

        {

                printf("Position cannot be <1.\n");

                return;

        }

        if (position == 1)

        {

                deleteFromFront();

                return;

        }



	struct node* temp = head;

        struct node* loc = NULL;



        for (int i = 1; i < position && temp != NULL; i++)

        {

                loc = temp;

                temp = temp->next;

        }

        if (temp == NULL)

        {

                printf("Position Not available.\n");

        }

        else

        {

                loc->next = temp->next;

                free(temp);

		printf("Item Deleted!\n");

        }

}





void deleteFromBack()

{

	if(head == NULL)

        {

                printf("List is empty.\n");

                return;

        }



        struct node* temp = head;

	struct node* loc = NULL;



        if(temp->next == NULL)

        {

                free(temp);

                head = NULL;

                return;

        }



        while(temp->next != NULL)

        {

		loc=temp;

                temp = temp->next;

        }

        loc->next = NULL;

        free(temp);

	printf("Item Deleted!\n");

}







void display()

{

	struct node* temp = head;

        if(temp == NULL)

        {

                printf("List is empty.\n");

                return;

        }

        printf("Head -> ");

        while(temp != NULL)

        {

                printf("%d -> ", temp->data);

                temp = temp->next;

        }

        printf("NULL\n");

}





int main()

{

        int choice,item,position;

        do{

                printf("\n1.Insert at front\n2.Insert at position\n3.Insert at back\n4.Delete from front\n5.Delete from postion\n");

                printf("6.Delete from back\n7.Display\n8.Exit\nEnter your choice :");

                scanf("%d",&choice);

                switch(choice)

                {

                        case(1):

                                printf("Enter item to insert at front :");

                                scanf("%d",&item);

                                insertAtFront(item);

                                break;

                        case(2):

                                printf("Enter item to be inserted :");

                                scanf("%d",&item);

                                printf("Enter the position :");

                                scanf("%d",&position);

                                insertAtPosition(item,position);

                                break;

                        case(3):

                                printf("Enter item to insert at back :");

                                scanf("%d",&item);

                                insertAtBack(item);

                                break;

                        case(4):

                                deleteFromFront();

                                break;

                        case(5):

                                printf("Enter the position :");

                                scanf("%d",&position);

                                deleteFromPosition(position);

                                break;

                        case(6):

                                deleteFromBack();

                                break;

                        case(7):

                                display();

                                break;

                        case(8):

                                printf("Exiting...\n");

                                break;

                        default:

                                printf("Invalid choice!Try again.\n");

                                break;

                }

        } while(choice!=8);



        return 0;

}
