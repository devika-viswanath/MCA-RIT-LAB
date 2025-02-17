// Program to implement Strongly Conncted Components (SCC)

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX 100

struct Node {
	int vertex;
	struct Node* next;
};

struct Graph {
	int numVertices;
	struct Node* adjList[MAX];
	struct Node* revAdjList[MAX];
	bool visited[MAX];
};

struct Node* createNode(int vertex)
{
	struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
	newNode->vertex = vertex;
	newNode->next = NULL;
	return newNode;
}

struct Graph* createGraph(int vertices)
{
	struct Graph* graph = (struct Graph*)malloc(sizeof(struct Graph));
	graph->numVertices = vertices;

	for (int i = 0; i < vertices; i++)
	{
		graph->adjList[i] = NULL;
		graph->revAdjList[i] = NULL;
		graph->visited[i] = false;
	}

	return graph;
}

void addEdge(struct Graph* graph, int src, int dest)
{
	struct Node* newNode = createNode(dest);
	newNode->next = graph->adjList[src];
	graph->adjList[src] = newNode;

	newNode = createNode(src);
	newNode->next = graph->revAdjList[dest];
	graph->revAdjList[dest] = newNode;
}

void dfsFillOrder(struct Graph* graph, int vertex, int* stack, int* top)
{
	graph->visited[vertex] = true;

	struct Node* temp = graph->adjList[vertex];
	while (temp)
	{
		if (!graph->visited[temp->vertex])
		{
			dfsFillOrder(graph, temp->vertex, stack, top);
        	}
        	temp = temp->next;
    	}

    	stack[(*top)++] = vertex;
}

void dfsOnReverseGraph(struct Graph* graph, int vertex)
{
	graph->visited[vertex] = true;
	printf("%d ", vertex);

	struct Node* temp = graph->revAdjList[vertex];
	while (temp)
	{
        	if (!graph->visited[temp->vertex])
		{
            		dfsOnReverseGraph(graph, temp->vertex);
        	}
        	temp = temp->next;
    	}
}

void findSCCs(struct Graph* graph)
{
	int stack[MAX], top = 0, count = 1;

    	for (int i = 0; i < graph->numVertices; i++)
	{
        	if (!graph->visited[i])
		{
            		dfsFillOrder(graph, i, stack, &top);
        	}
    	}

    	for (int i = 0; i < graph->numVertices; i++)
	{
        	graph->visited[i] = false;
    	}

    	printf("\nStrongly Connected Components:\n");
    	while (top > 0)
	{
        	int vertex = stack[--top];
        	if (!graph->visited[vertex])
		{
			printf("SCC %d: ", count++);
            		dfsOnReverseGraph(graph, vertex);
            		printf("\n");
        	}
    	}
	printf("We have %d strongly connected components.\n", count-1);
}

int main()
{
	int vertices, edges, src, dest;

	printf("Enter the number of vertices: ");
	scanf("%d", &vertices);

	struct Graph* graph = createGraph(vertices);

	printf("Enter the number of edges: ");
	scanf("%d", &edges);

	printf("Enter the edges (source destination):\n");
	for (int i = 0; i < edges; i++)
	{
		scanf("%d %d", &src, &dest);
		addEdge(graph, src, dest);
	}

	findSCCs(graph);

	return 0;
}
