#include<stdio.h>
#include<stdlib.h>
struct node{
    struct node *rep;
    struct node *next;
    int data;
    
}*heads[50],*tails[50];
static int countroot=0;
void makeset(int x){
    struct node *new=(struct node*)malloc(sizeof(struct node));
    new->rep=new;
    new->next=NULL;
    new->data=x;
    heads[countroot]=new;
    tails[countroot++]=new;
}
int search(int a){
    struct node *temp;
    for(int i=0;i<countroot;i++){
        temp=heads[i];
        while(temp!=NULL){
            if(temp->data==a){
                return 1;
            }
            temp=temp->next;
        }
        
    }
    return 0;
}
struct node* find(int x){
    struct node *temp=(struct node*)malloc(sizeof(struct node));
    for(int i=0;i<countroot;i++){
        temp=heads[i];
        while(temp!=NULL){
            if(temp->data==x){
                return temp->rep;
                
            }
            temp=temp->next;
        }
    }
    return NULL;
}
void unionset(int x,int y){
    int pos;int flag=0;
    struct node *tail2=(struct node*)malloc(sizeof(struct node));
    
    struct node *rep1=find(x);
    struct node *rep2=find(y);
    if(rep1==NULL||rep2==NULL){
        printf("elements not in DS");
        return;
    }
    if(rep1!=rep2){
        for(int j=0;j<countroot;j++){
            if(heads[j]==rep2){
                pos=j;
                flag=1;
                tail2=tails[j];
                countroot--;
            
                for(int i=pos;i<countroot;i++){
                    heads[i]=heads[i+1];
                    tails[i]=tails[i+1];
                    
                }
                if(flag==1){
                break;}
            }
        }
        for(int j=0;j<countroot;j++){
            if(heads[j]==rep1){
                tails[j]->next=rep2;
                tails[j]=tail2;
                break;
            }
        }
        while(rep2!=NULL){
            rep2->rep=rep1;
            rep2=rep2->next;
            
        }
            
    }
    
}
void main(){
    int choice;
    int x;int y;int flag=0;
    printf("\nmenu\n1.makeset\n2.display set representative\n3.find\n4.union\n5exit");
    
    do{
        printf("\nenter the choice");
        scanf("%d",&choice);
        switch(choice){
            case 1:
                printf("enter the element");
                scanf("%d",&x);
                if(search(x)==1){
                    printf("elemnt already in ds ..enter distinct num");
                    
                }
                else{
                    makeset(x);
                }
                break;
            case 2:
                for(int i=0;i<countroot;i++){
                    printf("%d",heads[i]->data);
                }
                break;
            case 3:
                printf("\nenter the element");
                scanf("%d",&x);
                
                struct node *rep=(struct node*)malloc(sizeof(struct node));
                rep=find(x);
                if(rep==NULL){
                    printf("the element not in the ds");
                }
                else{
                    printf("the rep of %d is %d",x,rep->data);}
                break;
            case 4:
                printf("\nenter the element1 ; ");
                scanf("%d",&x);
                printf("enter the element2; ");
                scanf("%d",&y);
                unionset(x,y);
                break;
            case 5:
                exit(0);
            default:
                printf("invalid choice");
        }
    }while(1);
}
