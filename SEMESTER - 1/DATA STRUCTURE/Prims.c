// Program to implement Prims Agorithm (MST)

#include <stdio.h>

int a, b, u, v, n, m, i, j, ne = 1;
int visited[10] = {0}, min, mincost = 0, cost[10][10];

void main() {
    printf("\nEnter the number of nodes: ");
    scanf("%d", &n);

    // Ask for the number of edges
    printf("Enter the number of edges: ");
    scanf("%d", &m);

    // Initialize the cost matrix with high values
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            if (i != j) {
                cost[i][j] = 999; // Set no edges initially as large value
            }
        }
    }

    // Take edges and their weights as input from the user
    printf("\nEnter the edges (vertex1 vertex2 weight):\n");
    for (int k = 0; k < m; k++) {
        int v1, v2, w;
        printf("Edge %d: ", k + 1);
        scanf("%d %d %d", &v1, &v2, &w);

        // Add the edge to the adjacency matrix
        cost[v1][v2] = w;
        cost[v2][v1] = w; // Since it's an undirected graph, set both directions
    }

    // Debugging: Print the cost matrix with 0 instead of 999 for no edge
    printf("\nCost matrix after input:\n");
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            if (cost[i][j] == 999) {
                printf("0 "); // Print 0 for no edge
            } else {
                printf("%d ", cost[i][j]);
            }
        }
        printf("\n");
    }

    visited[0] = 1; // Start from node 0
    printf("\n");

    // Prim's Algorithm to find Minimum Spanning Tree (MST)
    while (ne <= n - 1) {
        for (i = 0, min = 999; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (cost[i][j] < min && visited[i] != 0) {
                    min = cost[i][j];
                    a = u = i;
                    b = v = j;
                }
            }
        }

        if (visited[u] == 0 || visited[v] == 0) {
            printf("\nEdge %d: (%d %d) cost: %d", ne++, a, b, min);
            mincost += min;
            visited[b] = 1;
        }

        cost[a][b] = cost[b][a] = 999; // Mark the edge as used
    }

    // Print the total weight of the Minimum Spanning Tree (MST)
    printf("\n\nTotal weight of MST: %d\n", mincost);
}
