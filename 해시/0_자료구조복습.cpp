#include <stdlib.h>
#include <stdio.h>
#pragma warning(disable:4996)

/*
typedef struct Node {
	struct Node* prev;
	struct Node* next;
	char elem;
}Node;

void func_add(Node* h, Node* t, int r, char e) {
	Node* newNode = (Node*)malloc(sizeof(Node) * 1);

	while (r--) {
		h = h->next;
		if (h == NULL) {
			printf("invalid position\n");
			return;
		}
	}
	newNode->prev = h->prev;
	h->prev->next = newNode;
	newNode->next = h;
	h->prev = newNode;

	newNode->elem = e;
}

void func_delete(Node* h, Node* t, int r) {
	
	while (r--) {
		h = h->next;
		if (h == t) {
			printf("invalid position\n");
			return;
		}
	}
	h->prev->next = h->next;
	h->next->prev = h->prev;

	free(h);
}

int func_get(Node* h, Node* t, int r) {
	while (r--) {
		h = h->next;
		if (h == t) return -1;
	}
	return h->elem;
}

void func_print(Node* h, Node* t) {
	while (h != t->prev) {
		h = h->next;
		printf("%c", h->elem);
	}
	printf("\n");
}

int main()
{
	Node* h = (Node*)malloc(sizeof(Node) * 1);
	Node* t = (Node*)malloc(sizeof(Node) * 1);
	int n;

	h->next = t; h->prev = NULL;
	t->prev = h; t->next = NULL;

	scanf("%d", &n);

	while (n--) {
		char order, elem;
		int r, get;
		getchar();
		scanf("%c", &order);

		switch (order)
		{
		case 'A':
			scanf("%d %c", &r, &elem);
			func_add(h, t, r, elem);
			break;

		case 'D':
			scanf("%d", &r);
			func_delete(h, t, r);
			break;

		case 'G':
			scanf("%d", &r);
			get = func_get(h, t, r);
			if (get == -1) printf("invalid position\n");
			else printf("%c\n", get);
			break;

		case 'P':
			func_print(h, t);
			break;
		}
	}
}
*/
/*
5
A 1 S
A 2 t
A 3 r
A 3 a
P

9
A 1 D
A 2 a
A 3 y
D 1
P
G 3
A 1 S
P
G 3
*/

typedef struct Node {
	struct Node* left;
	struct Node* right;
	int elem;
}Node;

Node* newNode(int e) {
	Node* n = (Node*)malloc(sizeof(Node) * 1);

	n->left = NULL; 
	n->right = NULL;

	n->elem = e;
	return n;
}

Node* exp(Node* node, int elem) {
	Node* l, * r;

	if (node == NULL) return NULL;
	if (node->elem == elem) return node;

	l = exp(node->left, elem);
	r = exp(node->right, elem);

	if (l != NULL) return l;
	if (r != NULL) return r;

	return NULL;
}
int main()
{
	Node* root;
	int n, m, rt, lc, rc;

	scanf("%d", &n);
	scanf("%d %d %d", &rt, &lc, &rc);

	root = newNode(rt);
	root->left = newNode(lc);
	root->right = newNode(rc);

	while (--n) {
		scanf("%d %d %d", &rt, &lc, &rc);
		if (!lc && !rc) continue;

		Node* c = exp(root, rt);
		if (lc != 0)c->left = newNode(lc);
		if (rc != 0)c->right = newNode(rc);
	}

	scanf("%d", &m);

	while (m--) {
		char s[101];
		scanf("%s", s);

		Node* ep = root;
		printf(" %d", ep->elem);

		for (char* p = s; *p != '\0'; p++) {
			if (*p == 'L') ep = ep->left;
			else ep = ep->right;
			printf(" %d", ep->elem);
		}
		printf("\n");
	}
}

/*
9
5 3 9
3 8 15
8 0 2
2 0 0
15 0 0
9 7 10
7 12 0
12 0 0
10 0 0
3
RLL
LL
LR
*/