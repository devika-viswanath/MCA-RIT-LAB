
// Program to create ADT using Bit Strings

#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 32

int superSet[MAX_SIZE], superSetSize = 0;
int setA[MAX_SIZE], setASize = 0;
int setB[MAX_SIZE], setBSize = 0;
int bitStringA[MAX_SIZE], bitStringB[MAX_SIZE];

// Function prototypes

void getUniversalSet();
void getSet(int arr[], int *size);
int checkSetInUniversal(int arr[], int size);
void generateBitStrings();
void setUnion();
void setIntersection();
void setDifferenceAminusB();
void setDifferenceBminusA();
void printBitString(int arr[], int size);
void printSetFromBitString(int arr[], int size);


void getUniversalSet() {
    printf("Enter Universal Set Size (max %d): ", MAX_SIZE);
    scanf("%d", &superSetSize);
    if (superSetSize > MAX_SIZE) {
        printf("Error: Size exceeds maximum limit.\n");
        exit(1);
    }

    printf("Enter %d elements for the Universal Set:\n", superSetSize);
    for (int i = 0; i < superSetSize; i++) {
        printf("Element %d: ", i + 1);
        scanf("%d", &superSet[i]);
    }
}

void getSet(int arr[], int *size) {
    printf("Enter %d elements (must be in the Universal Set):\n", *size);
    for (int i = 0; i < *size; i++) {
        printf("Element %d: ", i + 1);
        scanf("%d", &arr[i]);
    }
}

int checkSetInUniversal(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        int found = 0;
        for (int j = 0; j < superSetSize; j++) {
            if (arr[i] == superSet[j]) {
                found = 1;
                break;
            }
        }
        if (!found) {
            printf("Error: Element %d is not in the Universal Set. Please enter the set again.\n", arr[i]);
            return 0;
        }
    }
    return 1;
}

void generateBitStrings() {
    for (int i = 0; i < superSetSize; i++) {
        bitStringA[i] = 0;
        bitStringB[i] = 0;
    }

    for (int i = 0; i < setASize; i++) {
        for (int j = 0; j < superSetSize; j++) {
            if (setA[i] == superSet[j]) {
                bitStringA[j] = 1;
                break;
            }
        }
    }

    for (int i = 0; i < setBSize; i++) {
        for (int j = 0; j < superSetSize; j++) {
            if (setB[i] == superSet[j]) {
                bitStringB[j] = 1;
                break;
            }
        }
    }

    printf("Set A Bit String: ");
    printBitString(bitStringA, superSetSize);
    printf("Set B Bit String: ");
    printBitString(bitStringB, superSetSize);
}

void setUnion() {
    int bitStringUnion[MAX_SIZE];
    for (int i = 0; i < superSetSize; i++) {
        bitStringUnion[i] = bitStringA[i] | bitStringB[i];
    }
    printf("Union: ");
    printBitString(bitStringUnion, superSetSize);
    printf("Union Result (Values): ");
    printSetFromBitString(bitStringUnion, superSetSize);
}

void setIntersection() {
    int bitStringIntersection[MAX_SIZE];
    for (int i = 0; i < superSetSize; i++) {
        bitStringIntersection[i] = bitStringA[i] & bitStringB[i];
    }
    printf("Intersection: ");
    printBitString(bitStringIntersection, superSetSize);
    printf("Intersection Result (Values): ");
    printSetFromBitString(bitStringIntersection, superSetSize);
}

void setDifferenceAminusB() {
    int bitStringDifferenceAminusB[MAX_SIZE];
    for (int i = 0; i < superSetSize; i++) {
        bitStringDifferenceAminusB[i] = bitStringA[i] & (1 - bitStringB[i]);
    }
    printf("Difference (A - B): ");
    printBitString(bitStringDifferenceAminusB, superSetSize);
    printf("Difference Result (A - B, Values): ");
    printSetFromBitString(bitStringDifferenceAminusB, superSetSize);
}

void setDifferenceBminusA() {
    int bitStringDifferenceBminusA[MAX_SIZE];
    for (int i = 0; i < superSetSize; i++) {
        bitStringDifferenceBminusA[i] = bitStringB[i] & (1 - bitStringA[i]);
    }
    printf("Difference (B - A): ");
    printBitString(bitStringDifferenceBminusA, superSetSize);
    printf("Difference Result (B - A, Values): ");
    printSetFromBitString(bitStringDifferenceBminusA, superSetSize);
}

void printBitString(int arr[], int size) {
    printf("{");
    for (int i = 0; i < size; i++) {
        printf("%d", arr[i]);
        if (i < size - 1) {
            printf(", ");
        }
    }
    printf("}\n");
}

void printSetFromBitString(int arr[], int size) {
    int first = 1;
    printf("{");
    for (int i = 0; i < size; i++) {
        if (arr[i] == 1) {
            if (!first) {
                printf(", ");
            }
            printf("%d", superSet[i]);
            first = 0;
        }
    }
    printf("}\n");
}




int main() {
    int choice;

    getUniversalSet();

    do {
        printf("Enter Set A Size (max %d): ", superSetSize);
        scanf("%d", &setASize);
        if (setASize > superSetSize) {
            printf("Error: Set A size cannot exceed Universal Set size.\n");
        }
    } while (setASize > superSetSize);

    do {
        getSet(setA, &setASize);
    } while (checkSetInUniversal(setA, setASize) == 0);

    do {
        printf("Enter Set B Size (max %d): ", superSetSize);
        scanf("%d", &setBSize);
        if (setBSize > superSetSize) {
            printf("Error: Set B size cannot exceed Universal Set size.\n");
        }
    } while (setBSize > superSetSize);

    do {
        getSet(setB, &setBSize);
    } while (checkSetInUniversal(setB, setBSize) == 0);

    generateBitStrings();

    do {
        printf("\nChoose an operation:\n");
        printf("1. Union of A and B\n");
        printf("2. Intersection of A and B\n");
        printf("3. Difference (A - B)\n");
        printf("4. Difference (B - A)\n");
        printf("5. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                setUnion();
                break;
            case 2:
                setIntersection();
                break;
            case 3:
                setDifferenceAminusB();
                break;
            case 4:
                setDifferenceBminusA();
                break;
            case 5:
                printf("Exiting program.\n");
                break;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 5);

    return 0;
}















