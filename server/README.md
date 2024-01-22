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

## Usage

### Definitions

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

### Endpoints

#### Create user – POST "/users"

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

#### List users – GET "/users"

```ts
type RequestBody = null;
type ResponseBody = StoredUser[];
```

#### Create category – POST "/categories"

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

#### List categories – GET "/categories"

```ts
type RequestBody = null;
type ResponseBody = StoredCategory[];
```

#### Create post – POST "/posts"

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

#### List posts – GET "/posts"

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

#### List one post – GET "/posts/:postId"

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

#### Create comment – POST "/comments"

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

#### Rank contribution – PUT "/ranking/:contributionId/:action"

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
