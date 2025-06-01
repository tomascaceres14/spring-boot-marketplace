import {
  QueryClient,
  QueryClientProvider,
  useQuery,
} from "@tanstack/react-query";

const queryClient = new QueryClient();

function Example() {
  const { isPending, error, data } = useQuery({
    queryKey: ["repoData"],
    queryFn: () =>
      fetch("http://localhost:8080/api/v1/home/products").then((res) =>
        res.json()
      ),
  });

  if (isPending) return "Loading...";

  if (error) return "An error has occurred: " + error.message;

  return (
    <div>
      <h1>{data.content[0].title}</h1>
      <p>{data.content[0].description}</p>
    </div>
  );
}

function App() {
  return (
    <QueryClientProvider client={queryClient}>
      <header>
        <nav>
          <ul>
            <li>Home</li>
            <li>Products</li>
            <input type="string" placeholder="Search..." />
            <li>Home</li>
            <li>Account</li>
          </ul>
        </nav>
      </header>
      <Example />
    </QueryClientProvider>
  );
}

export default App;
