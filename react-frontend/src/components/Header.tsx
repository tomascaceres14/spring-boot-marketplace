import {
  Popover,
  PopoverContent,
  PopoverTrigger,
} from "@/components/ui/popover";
import { Button } from "./ui/button";

export default function Header() {
  return (
    <header className="w-full border-b bg-white shadow">
      {/* Top Bar */}
      <div className="flex items-center justify-between px-4 py-2">
        {/* Logo */}
        <div className="flex items-center space-x-2">
          <div className="text-xl font-bold text-yellow-500">Logo</div>
        </div>

        {/* Search Input */}
        <div className="flex-1 mx-4 max-w-2xl">
          <input
            type="text"
            placeholder="Search products or shops..."
            className="w-full rounded-md border border-gray-300 px-4 py-2 text-sm focus:outline-none focus:ring-2 focus:ring-yellow-500"
          />
        </div>

        {/* Cuenta / Config */}
        <div className="flex items-center space-x-4 text-sm text-gray-700">
          <button className="hover:underline">Mi cuenta</button>
          <button className="hover:underline">Configuración</button>
        </div>
      </div>

      {/* Bottom Bar */}
      <div className="flex items-center justify-between bg-gray-100 px-4 py-2 text-sm">
        {/* Selector de categorías */}
        <li className="flex gap-5">
          <Popover>
            <PopoverTrigger>
              <Button>Products</Button>
            </PopoverTrigger>
            <PopoverContent>
              <div>Clothes</div>
            </PopoverContent>
          </Popover>
          <ul>Products</ul>
          <ul>Shops</ul>
          <ul>Services</ul>
          <ul>Professionals</ul>
        </li>

        {/* Links adicionales opcionales */}
        <div className="hidden md:flex items-center space-x-4 ml-4 text-gray-600">
          <a href="#" className="hover:underline">
            Ofertas
          </a>
          <a href="#" className="hover:underline">
            Historial
          </a>
          <a href="#" className="hover:underline">
            Ayuda
          </a>
        </div>
      </div>
    </header>
  );
}
