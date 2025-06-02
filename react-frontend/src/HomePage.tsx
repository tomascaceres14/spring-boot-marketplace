import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Avatar, AvatarImage, AvatarFallback } from "@/components/ui/avatar";
import { ShoppingCart, Search } from "lucide-react";

export default function HomePage() {
  return (
    <div className="bg-[#3AAAC5] min-h-screen text-white font-sans">
      {/* Top Header */}
      <div className="flex flex-col items-center w-full px-4 py-4 md:flex-row md:justify-between md:px-12">
        <h1 className="text-xl font-bold mb-2 md:mb-0">CAMBALACHE</h1>
        <div className="flex items-center rounded-full bg-white px-2">
          <Input
            className="border-0 w-100 bg-white text-black placeholder:text-gray-400"
            placeholder="Buscar..."
          />
          <button className="">
            <Search className="text-black" />
          </button>
        </div>
        <div className="flex gap-4 items-center">
          <Avatar>
            <AvatarImage src="https://avatars.githubusercontent.com/u/92989104?v=4" />
            <AvatarFallback>TA</AvatarFallback>
          </Avatar>
          <ShoppingCart />
        </div>
      </div>

      {/* Hero Banner */}
      <div className="flex flex-col md:flex-row bg-[#8BD1E3] text-white rounded-xl mx-4 md:mx-12 p-6 md:p-10 items-center">
        <img
          src="https://cdn.openai.com/dall-e-3/demos/text2image/2.png"
          alt="Hero"
          className="w-full max-w-sm mb-6 md:mb-0 md:mr-8"
        />
        <div className="flex flex-col gap-4 text-center md:text-left">
          <h2 className="text-3xl font-bold">MUESTRA TU NEGOCIO</h2>
          <p>
            Publica tu negocio y llega a más clientes. Con Cambalache, es fácil,
            rápido y efectivo.
          </p>
          <div>
            <Button className="bg-orange-500 hover:bg-orange-600 text-white rounded-full px-6">
              CONOCE MÁS
            </Button>
          </div>
        </div>
      </div>

      {/* Categorías */}
      <div className="text-center mt-10 px-4">
        <h3 className="text-xl font-semibold mb-4">¿QUÉ ESTÁS BUSCANDO?</h3>
        <div className="flex flex-col sm:flex-row justify-center gap-4">
          <div className="bg-white text-orange-500 rounded-2xl px-6 py-3 font-bold">
            SERVICIOS
          </div>
          <div className="bg-white text-pink-500 rounded-2xl px-6 py-3 font-bold">
            TIENDAS
          </div>
          <div className="bg-white text-green-500 rounded-2xl px-6 py-3 font-bold">
            PRODUCTOS
          </div>
        </div>
      </div>

      {/* Secciones */}
      <Section title="MEJOR VALORADOS" />
      <Section title="SUGERENCIAS" />
      <Section title="SERVICIOS DEL HOGAR" />
    </div>
  );
}

function Section({ title }: { title: string }) {
  return (
    <div className="mt-10 px-4 md:px-12">
      <h4 className="text-lg font-bold mb-4">{title}</h4>
      <div className="flex gap-4 overflow-x-auto pb-2">
        {[1, 2, 3, 4].map((item) => (
          <CardItem key={item} />
        ))}
      </div>
    </div>
  );
}

function CardItem() {
  return (
    <div className="min-w-[180px] bg-white text-black rounded-xl overflow-hidden shadow-md">
      <img
        src="https://source.unsplash.com/200x150/?business"
        alt="card"
        className="w-full h-28 object-cover"
      />
      <div className="p-2">
        <p className="font-semibold text-sm">Nombre del negocio</p>
        <div className="flex items-center text-sm gap-1">
          <span className="text-yellow-500">★</span>
          <span>4.8</span>
          <span className="ml-auto text-green-500 font-semibold text-xs">
            Abierto
          </span>
        </div>
      </div>
    </div>
  );
}
