// // Program to implement Kruskals Algorithm
#include <stdio.h>
#include <stdlib.h>

int i, j, k, a, b, u, v, n, ne = 1;
int min, mincost = 0, cost[9][9], parent[9];

int find(int);
int uni(int, int);

void main() {
    printf("\nEnter the number of vertices: ");
    scanf("%d", &n);

    printf("\nEnter the cost adjacency matrix:\n");
    for (i = 0; i<n; i++) {
        for (j = 0; j<n; j++) {
            scanf("%d", &cost[i][j]);
            if (cost[i][j] == 0) {
                cost[i][j] = 999; // Represent no edge with a large value
            }
        }
    }

    printf("The edges of the Minimum Cost Spanning Tree are:\n");
    while (ne < n) {
        for (i = 0, min = 999; i<n; i++) {
            for (j = 0; j<n; j++) {
                if (cost[i][j] < min) {
                    min = cost[i][j];
                    a = u = i;
                    b = v = j;
                }
            }
        }

        u = find(u);
        v = find(v);

        if (uni(u, v)) {
            printf("%d edge (%d,%d) = %d\n", ne++, a, b, min);
            mincost += min;
        }

        cost[a][b] = cost[b][a] = 999; // Mark edge as used
    }

    printf("\nMinimum cost = %d\n", mincost);
}

int find(int i) {
    while (parent[i]) {
        i = parent[i];
    }
    return i;
}

int uni(int i, int j) {
    if (i != j) {
        parent[j] = i;
        return 1;
    }
    return 0;
}















































// #include <stdio.h>
// #include <stdlib.h>

// #define MAX 20

// // Structure to represent a weighted edge
// typedef struct {
//     int u, v, weight;
// } Edge;

// // Global variables
// int parent[MAX], rank[MAX];

// // Function to initialize the Disjoint Set data structure
// void initializeSet(int n) {
//     for (int i = 0; i < n; i++) {
//         parent[i] = i;
//         rank[i] = 0;
//     }
// }

// // Find operation for the Disjoint Set data structure (with path compression)
// int find(int i) {
//     if (i != parent[i]) {
//         parent[i] = find(parent[i]);
//     }
//     return parent[i];
// }

// // Union operation for the Disjoint Set data structure (by rank)
// void unionSets(int u, int v) {
//     int root_u = find(u);
//     int root_v = find(v);
    
//     if (root_u != root_v) {
//         // Union by rank
//         if (rank[root_u] > rank[root_v]) {
//             parent[root_v] = root_u;
//         } else if (rank[root_u] < rank[root_v]) {
//             parent[root_u] = root_v;
//         } else {
//             parent[root_v] = root_u;
//             rank[root_u]++;
//         }
//     }
// }

// // Function to compare two edges (used for sorting)
// int compareEdges(const void *a, const void *b) {
//     return ((Edge*)a)->weight - ((Edge*)b)->weight;
// }

// // Kruskal's Algorithm to find MST
// void kruskal(Edge edges[], int n, int m) {
//     int mst_weight = 0;
//     int mst_edges = 0;

//     // Sort edges by weight
//     qsort(edges, m, sizeof(Edge), compareEdges);

//     printf("\nEdges in the Minimum Spanning Tree (MST):\n");

//     for (int i = 0; i < m; i++) {
//         int u = edges[i].u;
//         int v = edges[i].v;
//         int weight = edges[i].weight;

//         // If adding this edge does not form a cycle
//         if (find(u) != find(v)) {
//             unionSets(u, v);
//             printf("Edge (%d, %d) weight: %d\n", u, v, weight);
//             mst_weight += weight;
//             mst_edges++;

//             // If we have n-1 edges, MST is complete
//             if (mst_edges == n - 1) {
//                 break;
//             }
//         }
//     }

//     printf("\nTotal weight of MST: %d\n", mst_weight);
// }

// int main() {
//     int n, m;

//     // Input number of nodes and edges
//     printf("Enter the number of nodes: ");
//     scanf("%d", &n);

//     printf("Enter the number of edges: ");
//     scanf("%d", &m);

//     // Declare an array of edges
//     Edge edges[m];

//     // Input the edges
//     printf("\nEnter the edges (vertex1 vertex2 weight):\n");
//     for (int i = 0; i < m; i++) {
//         printf("Edge %d: ", i + 1);
//         scanf("%d %d %d", &edges[i].u, &edges[i].v, &edges[i].weight);
//     }

//     // Initialize Disjoint Set for Kruskal's Algorithm
//     initializeSet(n);

//     // Apply Kruskal's Algorithm
//     kruskal(edges, n, m);

//     return 0;
// } 
