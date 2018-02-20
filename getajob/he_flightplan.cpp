#include<iostream>
#include <list>
using namespace std;

std::stringstream shortestpath, newpath;
int cities = 0;
int shortesttime = 0, newtime = 0;

class Graph
{
    int V;
    list<int> *adj;
    void getPathUtil(int , int , bool [], int [], int &, int , int);
 
public:
    Graph(int V);
    void addEdge(int u, int v);
    void getPath(int s, int d, int T, int C);
};
 
Graph::Graph(int V)
{
    this->V = V;
    adj = new list<int>[V];
}
 
void Graph::addEdge(int u, int v)
{
    adj[u].push_back(v);
}

void Graph::getPath(int s, int d, int T, int C)
{
    bool *visited = new bool[V];

    int *path = new int[V];
    int path_index = 0;

    for (int i = 0; i < V; i++)
        visited[i] = false;

    getPathUtil(s, d, visited, path, path_index, T, C);
}

void Graph::getPathUtil(int u, int d, bool visited[],
                              int path[], int &path_index, int T, int C)
{
    visited[u] = true;
    path[path_index] = u;
    path_index++;

    if (u == d)
    {
        if(path == ""){
            for (int i = 0; i<path_index; i++){
                if(i!=0){
                    shortesttime += C;
                    int rem = shortesttime%2*T;
                    if(rem < T){
                        shortesttime += rem;
                    }
                }
                shortestpath << path[i] << " ";
            }
            cities = path_index;
        }
        else{
            for (int i = 0; i<path_index; i++){
                if(i!=0){
                    newtime += C;
                    int rem = newtime%2*T;
                    if(rem < T){
                        newtime += rem;
                    }
                }
                newpath << path[i] << " ";
            }
            if(std::string(newpath.str()) < std::string(path.str()) && newtime < shortesttime){
                shortestpath = newpath;
                cities = path_index;
            }
        }
        newtime = 0;
    }
    else
    {
        list<int>::iterator i;
        for (i = adj[u].begin(); i != adj[u].end(); ++i)
            if (!visited[*i])
                getPathUtil(*i, d, visited, path, path_index, T, C);
    }
    path_index--;
    visited[u] = false;
}
 
int main()
{
    int N, M, T, C;
    cin >> N;
    cin >> M;
    cin >> T;
    cin >> C;
    Graph g(N);
    for(int i = 0; i < M; i++){
        int u,v;
        cin >> u;
        cin >> v;
        g.addEdge(u-1,v-1);
        g.addEdge(v-1,u-1);
    }
    int x, y;
    cin >> x;
    cin >> y;
    g.getPath(x - 1, y - 1, T, C);
    return 0;
}