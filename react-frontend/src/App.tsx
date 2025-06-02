import {
  QueryClient,
  QueryClientProvider,
  useQuery,
} from "@tanstack/react-query";
import Header from "./components/Header";
import HomePage from "./HomePage";

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
      {/* <Header />
      <Example /> */}
      <HomePage />
    </QueryClientProvider>
  );
}

export default App;
