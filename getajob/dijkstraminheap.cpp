#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <iostream>
#include <vector>

using namespace std;

enum state{NEW, IN_Q, VISITED};

/*class Edge{
	public:
	 	int u,v,wt;
		Edge(int u1, int v1, int wt1){
			u=u1;
			v=v1;
			wt=wt1;
		}
};*/

class Vertex{
	public:
		int label;
		int cost;
		int wt;
		state s1;
		vector<Vertex> neighbors;
		Vertex(int label1){
			label=label1;
		}
};

class Graph{
	public:
		vector<Vertex> vertices;
		void addVertices(){
			for(int i=0;i<=8;i++){
				Vertex v(i);
				vertices.at(i)=v;
			}
		}
		void addEdge(int u, int v, int wt){
			vertices[u].neighbors.push_back(vertices[v]);
			vertices[v].wt = wt;
		}
};

void createGraph(){
	Graph g;
	g.addVertices();
	g.addEdge(0,1,4);
	g.addEdge(0,7,8);
	g.addEdge(1,2,8);
	g.addEdge(1,7,11);
	g.addEdge(2,3,7);
	g.addEdge(2,5,4);
	g.addEdge(2,8,2);
	g.addEdge(3,4,9);
	g.addEdge(3,5,14);
	g.addEdge(4,5,10);
	g.addEdge(5,6,2);
	g.addEdge(6,7,1);
	g.addEdge(6,8,6);
	g.addEdge(7,8,7);
}

int main(){
	createGraph();
}