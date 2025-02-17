// Program to implement Strongly Conncted Components (SCC)

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_VERTICES 10

// Graph structure
struct Graph {
    int numVertices;
    int adjMatrix[MAX_VERTICES][MAX_VERTICES]; // Adjacency matrix
    int reverseAdjMatrix[MAX_VERTICES][MAX_VERTICES]; // Reversed adjacency matrix
};

// Function to initialize the graph
void initGraph(struct Graph* graph, int vertices) {
    graph->numVertices = vertices;

    // Initialize adjacency matrices with 0 (no edges)
    for (int i = 0; i < vertices; i++) {
        for (int j = 0; j < vertices; j++) {
            graph->adjMatrix[i][j] = 0;
            graph->reverseAdjMatrix[i][j] = 0;
        }
    }
}

// Function to add an edge to the graph (Directed)
void addEdge(struct Graph* graph, int src, int dest) {
    graph->adjMatrix[src][dest] = 1;  // Add edge in the original graph

    // Reverse edge for the reverse graph
    graph->reverseAdjMatrix[dest][src] = 1;
}

// DFS (Depth First Search) to explore the graph
void DFS(struct Graph* graph, int vertex, bool visited[], int stack[], int* stackIndex, int adjMatrix[MAX_VERTICES][MAX_VERTICES]) {
    visited[vertex] = true;

    // Visit all adjacent vertices
    for (int i = 0; i < graph->numVertices; i++) {
        if (adjMatrix[vertex][i] == 1 && !visited[i]) {
            DFS(graph, i, visited, stack, stackIndex, adjMatrix);
        }
    }

    // Push the vertex to the stack when DFS finishes exploring it
    stack[*stackIndex] = vertex;
    (*stackIndex)++;
}

// DFS on reversed graph to find SCCs
void DFSReverse(struct Graph* graph, int vertex, bool visited[], int* component, int reverseAdjMatrix[MAX_VERTICES][MAX_VERTICES]) {
    visited[vertex] = true;
    component[vertex] = 1;  // Mark the vertex as part of the current SCC

    // Visit all adjacent vertices in the reversed graph
    for (int i = 0; i < graph->numVertices; i++) {
        if (reverseAdjMatrix[vertex][i] == 1 && !visited[i]) {
            DFSReverse(graph, i, visited, component, reverseAdjMatrix);
        }
    }
}

// Function to perform Kosaraju's Algorithm to find SCCs
void kosarajuSCC(struct Graph* graph) {
    bool visited[MAX_VERTICES] = { false };
    int stack[MAX_VERTICES];
    int stackIndex = 0;

    // Step 1: Perform DFS on the original graph and fill the stack with the vertices in finishing time order
    for (int i = 0; i < graph->numVertices; i++) {
        if (!visited[i]) {
            DFS(graph, i, visited, stack, &stackIndex, graph->adjMatrix);
        }
    }

    // Step 2: Reverse the graph is already done in `addEdge` function

    // Step 3: Perform DFS on the reversed graph, using the order in the stack
    for (int i = 0; i < graph->numVertices; i++) {
        visited[i] = false;  // Reset visited array
    }

    printf("Strongly Connected Components (SCCs):\n");

    while (stackIndex > 0) {
        int vertex = stack[--stackIndex];
        if (!visited[vertex]) {
            int component[MAX_VERTICES] = { 0 }; // To track the SCC

            // DFS on the reverse graph to get all nodes in this SCC
            DFSReverse(graph, vertex, visited, component, graph->reverseAdjMatrix);

            // Print the SCC
            printf("{ ");
            for (int i = 0; i < graph->numVertices; i++) {
                if (component[i]) {
                    printf("%d ", i);
                }
            }
            printf("}\n");
        }
    }
}

// Function to display the graph (adjacency matrix)
void displayGraph(struct Graph* graph) {
    printf("\nGraph Representation (Adjacency Matrix):\n");
    for (int i = 0; i < graph->numVertices; i++) {
        for (int j = 0; j < graph->numVertices; j++) {
            printf("%d ", graph->adjMatrix[i][j]);
        }
        printf("\n");
    }
}

int main() {
    struct Graph graph;
    int vertices, edges, src, dest, choice;

    // Input number of vertices and edges
    printf("Enter the number of vertices: ");
    scanf("%d", &vertices);
    initGraph(&graph, vertices);

    // Input edges
    printf("Enter the number of edges: ");
    scanf("%d", &edges);

    for (int i = 0; i < edges; i++) {
        printf("Enter edge %d (source destination): ", i + 1);
        scanf("%d %d", &src, &dest);

        // Add directed edge to the graph
        if (src >= 0 && src < vertices && dest >= 0 && dest < vertices) {
            addEdge(&graph, src, dest);
        } else {
            printf("Invalid edge! Please enter vertices within the range of 0 to %d.\n", vertices - 1);
            i--;  // Decrement i to allow user to input the edge again
        }
    }

    // Main menu
    do {
        printf("\nMenu:\n");
        printf("1. Display Graph\n");
        printf("2. Find Strongly Connected Components (SCCs)\n");
        printf("3. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                displayGraph(&graph);
                break;
            case 2:
                kosarajuSCC(&graph);
                break;
            case 3:
                printf("Exiting the program.\n");
                break;
            default:
                printf("Invalid choice! Please try again.\n");
        }
    } while (choice != 3);

    return 0;
}
