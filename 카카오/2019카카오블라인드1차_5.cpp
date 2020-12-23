#include<bits/stdc++.h>

using namespace std;

struct node {
    int x;
    int y;
    int idx;
};

struct tree {
    tree* l;
    tree* r;
    node node;
};

bool compare(node a, node b);
void add_child(tree* parent, tree* child);
void preorder(tree* cur, vector<int>& v);
void postorder(tree* cur, vector<int>& v);

vector<vector<int>> solution(vector<vector<int>> nodeinfo) {
    vector<vector<int>> answer(2);
    vector<node> nodes;

    for (int i = 0; i < nodeinfo.size(); i++) {
        node tmp;
        tmp.x = nodeinfo[i][0];
        tmp.y = nodeinfo[i][1];
        tmp.idx = i + 1;

        nodes.push_back(tmp);
    }

    sort(nodes.begin(), nodes.end(), compare);

    tree* root = new tree();
    root->node = nodes[0];
    root->l = NULL;
    root->r = NULL;

    for (int i = 1; i < nodes.size(); i++) {
        tree* cur = new tree();
        cur->node = nodes[i];
        cur->l = NULL;
        cur->r = NULL;

        add_child(root, cur);
    }

    preorder(root, answer[0]);
    postorder(root, answer[1]);

    return answer;
}

bool compare(node a, node b) {
    if (a.y == b.y) {
        return a.x < b.x;
    }
    else {
        return a.y > b.y;
    }
}

void add_child(tree* parent, tree* child) {
    if (parent->node.x > child->node.x) {
        if (parent->l == NULL) {
            parent->l = child;
        }
        else {
            add_child(parent->l, child);
        }
    }
    else {
        if (parent->r == NULL) {
            parent->r = child;
        }
        else {
            add_child(parent->r, child);
        }

    }
}

void preorder(tree* cur, vector<int>& v) {
    if (cur == NULL)
        return;

    v.push_back(cur->node.idx);
    preorder(cur->l, v);
    preorder(cur->r, v);
}

void postorder(tree* cur, vector<int>& v) {
    if (cur == NULL)
        return;

    postorder(cur->l, v);
    postorder(cur->r, v);
    v.push_back(cur->node.idx);
}


int main() {
    vector<vector<int>> v = solution({{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}} );

    for (auto x : v) {
        for (auto y : x) {
            cout << y << " ";
        }
        cout << endl;
    }
}