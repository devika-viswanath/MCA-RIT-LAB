#include <stdio.h>
#include <stdlib.h>

struct node {
    struct node *left;
    struct node *right;
    int data;
};

struct node *root;

struct node *newnode(int value) {
    struct node *newnode = (struct node*)malloc(sizeof(struct node));
    newnode->data = value;
    newnode->left = NULL;
    newnode->right = NULL;
    return newnode;
}

struct node *insert(struct node *root, int value) {
    if (root == NULL) {
        return newnode(value);
    } else if (value == root->data) {
        printf("Same data can't be stored\n");
        return root; // Important: return root to avoid infinite recursion
    } else if (value > root->data) {
        root->right = insert(root->right, value);
    } else {
        root->left = insert(root->left, value);
    }
    return root;
}

void inorderTraversal(struct node *root) {
    if (root == NULL) {
        return;
    }
    inorderTraversal(root->left);
    printf("%d->", root->data);
    inorderTraversal(root->right);
}

void preorderTraversal(struct node *root) {
    if (root == NULL) {
        return;
    }
    printf("%d->", root->data);
    preorderTraversal(root->left);
    preorderTraversal(root->right);
}

void postorderTraversal(struct node *root) {
    if (root == NULL) {
        return;
    }
    postorderTraversal(root->left);
    postorderTraversal(root->right);
    printf("%d->", root->data);
}

struct node *search(struct node *root, int key) {
    if (root == NULL) {
        printf("\nNOT FOUND\n");
        return NULL; // Return NULL if not found
    } else if (root->data == key) {
        printf("\nFOUND\n");
        return root; // Return the found node
    } else if (root->data < key) {
        return search(root->right, key);
    } else {
        return search(root->left, key);
    }
}

struct node *minValueNode(struct node *root) {
    struct node *current = root;
    while (current && current->left != NULL) {
        current = current->left;
    }
    return current;
}

struct node *deleteNode(struct node *root, int key) {
    if (root == NULL) {
        return root;
    }
    if (key < root->data) {
        root->left = deleteNode(root->left, key);
    } else if (key > root->data) {
        root->right = deleteNode(root->right, key);
    } else {
        if (root->left == NULL) {
            struct node *temp = root->right;
            free(root);
            return temp;
        } else if (root->right == NULL) {
            struct node *temp = root->left;
            free(root);
            return temp;
        }
        struct node *temp = minValueNode(root->right);
        root->data = temp->data;
        root->right = deleteNode(root->right, temp->data);
    }
    return root;
}

int main() {
    int opt;
    int value, searchv, key;
    do {
        printf("\n 1) insert Node \n 2) search\n 3) inorderTraversal \n 4) preorderTraversal \n  5) postorderTraversal \n 6)delete \n 7) exit \n ");
        printf("choose an option ::");
        scanf("%d", &opt);
        switch (opt) {
           
            case 1:
                printf("\n enter a number:");
                scanf("%d", &value);
                root = insert(root, value);
                break;
            case 2:
                printf("\n enter a number:");
                scanf("%d", &searchv);
                search(root, searchv);
                break;
            case 3:
                inorderTraversal(root);
                break;
            case 4:
                preorderTraversal(root);
                break;
            case 5:
                postorderTraversal(root);
                break;
            case 6:
                printf("\n enter a number to delete:");
                scanf("%d", &key);
                deleteNode(root, key);
                break;
            default:
                printf("invalid option!\n");
        }
    } while (opt != 7);
}
