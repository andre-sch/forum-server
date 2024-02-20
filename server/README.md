# Forum Server

## Config

### Prerequisites

- Connect to MySQL database
- Install Maven CLI

### ORM with Hibernate

- Using JPA standard, you must replace `persistence.example.xml` in `resources/META-INF/`
  by removing .example extension and changing connection properties – url, user and password – to your own.

### Migrations with Flyway

- Replace `flyway.example.conf` in root using the same process listed in the previous section.
- To get the current state of the database, run `mvn flyway:migrate` on terminal in `server` directory.

## Endpoints

- User

  - Create – `POST /users`
  - List – `GET /users`
  - Update – `PUT /users/:userId`
  - Delete – `DELETE /users/:userId`

- Category

  - Create – `POST /categories`
  - List – `GET /categories`
  - Update – `PUT /categories/:categoryName`
  - Delete – `DELETE /categories/:categoryName`

- Post

  - Create – `POST /posts`
  - List – `GET /posts`
  - List thread – `GET /posts/:postId`
  - Update – `PUT /posts/:postId`
  - Delete – `DELETE /posts/:postId`

- Comment

  - Create – `POST /comments`
  - Update – `PUT /comments/:commentId`
  - Delete – `DELETE /comments/:commentId`

- Rank contribution – `PUT /ranking/:contributionId/:action`

## Definitions

```ts
type User = {
  id: string;
  name: string;
  email: string;
  avatarUrl: string;
};
```

```ts
type Category = {
  name: string;
  description: string;
  color: string;
};
```

## User

### Create – `POST /users`

```ts
type RequestBody = {
  name: string;
  email: string;
  password: string;
  avatarUrl: string;
};
```

```ts
type ResponseBody = StoredUser;
type StoredUser = User & { createdAt: number };
```

### List – `GET /users`

```ts
type RequestBody = null;
type ResponseBody = StoredUser[];
```

### Update – `PUT /users/:userId`

Equivalent to user creation.

### Delete – `DELETE /users/:userId`

```ts
type RequestBody = null;
type ResponseBody = null;
```

## Category

### Create – `POST /categories`

```ts
type RequestBody = {
  name: string;
  description: string;
};
```

```ts
type ResponseBody = StoredCategory;
type StoredCategory = Category & { createdAt: number };
```

### List – `GET /categories`

```ts
type RequestBody = null;
type ResponseBody = StoredCategory[];
```

### Update – `PUT /categories/:categoryName`

```ts
type RequestBody = {
  name: string;
  description: string;
  color: string;
};
```

```ts
type ResponseBody = StoredCategory;
type StoredCategory = Category & { createdAt: number };
```

### Delete – `DELETE /categories/:categoryName`

```ts
type RequestBody = null;
type ResponseBody = null;
```

## Post

### Create – `POST /posts`

```ts
type RequestBody = {
  title: string;
  content: string;
  authorId: string;
  categoryNames: string[];
};
```

`authorId` references users and `categoryNames` references categories.

```ts
type ResponseBody = {
  id: string;
  title: string;
  content: string;
  author: User;
  categories: Category[];
  createdAt: number;
  lastUpdate: number;
};
```

### List – `GET /posts`

```ts
type RequestQueryParams = {
  author: string | undefined;
  category: string[] | undefined;
};
```

`author` references a name (or a subsequence) of an author.  
`category` is a multi-valued field which references categories.

Query example: GET /posts **?author=** john **&category=** test **&category=** programming

```ts
type ResponseBody = Post[];

type Post = {
  id: string;
  title: string;
  content: string;
  author: User;
  categories: Category[];
  upVotes: string[];
  downVotes: string[];
  createdAt: number;
  lastUpdate: number;
};
```

`upVotes` and `downVotes` references users who ranked the contribution.

### List thread – `GET /posts/:postId`

```ts
type RequestBody = null;
type RequestPathParams = { postId: string };
```

```ts
type ResponseBody = {
  id: string;
  title: string;
  content: string;
  author: User;
  categories: Category[];
  upVotes: string[];
  downVotes: string[];
  createdAt: number;
  lastUpdate: number;
  comments: Comment[];
};

type Comment = {
  id: string;
  content: string;
  author: User;
  upVotes: string[];
  downVotes: string[];
  createdAt: number;
  lastUpdate: number;
  replies: Comment[];
};
```

### Update – `PUT /posts/:postId`

```ts
type RequestBody = {
  title: string;
  content: string;
  categoryNames: string[];
};
```

`ResponseBody` is equal to post creation.

### Delete – `DELETE /posts/:postId`

```ts
type RequestBody = null;
type ResponseBody = null;
```

## Comment

### Create – `POST /comments`

```ts
type RequestBody = {
  parentId: string;
  authorId: string;
  content: string;
};
```

`parentId` references a contribution.

```ts
type ResponseBody = {
  id: string;
  parentId: string;
  content: string;
  author: User;
  createdAt: number;
  lastUpdate: number;
};
```

### Update – `PUT /comments/:commentId`

```ts
type RequestBody = {
  content: string;
};
```

`ResponseBody` is equal to comment creation.

### Delete – `DELETE /comments/:commentId`

```ts
type RequestBody = null;
type ResponseBody = null;
```

## Ranking

### Rank contribution – `PUT /ranking/:contributionId/:action`

```ts
type RequestBody = { userId: string };
type RequestPathParams = { contributionId: string; action: RankingAction };
type RankingAction = "upvote" | "downvote" | "cancel";
```

```ts
type ResponseBody = {
  userId: string;
  contributionId: string;
  vote: string;
};
```
