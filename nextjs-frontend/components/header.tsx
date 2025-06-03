import { Search, ShoppingCart, User, ChevronDown } from "lucide-react"
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { DropdownMenu, DropdownMenuContent, DropdownMenuItem, DropdownMenuTrigger } from "@/components/ui/dropdown-menu"
import { Badge } from "@/components/ui/badge"

export function Header() {
  return (
    <header className="border-b bg-white sticky top-0 z-50">
      {/* Upper Header */}
      <div className="border-b border-gray-100">
        <div className="container mx-auto px-4 py-3">
          <div className="flex items-center justify-between">
            {/* Logo */}
            <div className="flex items-center">
              <h1 className="text-2xl font-bold text-primary">LocalMarket</h1>
            </div>

            {/* Search Bar */}
            <div className="flex-1 max-w-2xl mx-8">
              <div className="relative">
                <Search className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400 h-4 w-4" />
                <Input
                  type="search"
                  placeholder="Search for products, services, shops, or professionals..."
                  className="pl-10 pr-4 py-2 w-full"
                />
              </div>
            </div>

            {/* User Actions */}
            <div className="flex items-center space-x-4">
              <Button variant="ghost" size="icon">
                <User className="h-5 w-5" />
              </Button>
              <Button variant="ghost" size="icon" className="relative">
                <ShoppingCart className="h-5 w-5" />
                <Badge className="absolute -top-2 -right-2 h-5 w-5 rounded-full p-0 flex items-center justify-center text-xs">
                  3
                </Badge>
              </Button>
            </div>
          </div>
        </div>
      </div>

      {/* Lower Header - Navigation */}
      <div className="bg-gray-50">
        <div className="container mx-auto px-4 py-2">
          <nav className="flex items-center space-x-8">
            <DropdownMenu>
              <DropdownMenuTrigger asChild>
                <Button variant="ghost" className="flex items-center space-x-1">
                  <span>Professionals</span>
                  <ChevronDown className="h-4 w-4" />
                </Button>
              </DropdownMenuTrigger>
              <DropdownMenuContent>
                <DropdownMenuItem>Plumbers</DropdownMenuItem>
                <DropdownMenuItem>Electricians</DropdownMenuItem>
                <DropdownMenuItem>Cleaners</DropdownMenuItem>
                <DropdownMenuItem>Tutors</DropdownMenuItem>
                <DropdownMenuItem>Personal Trainers</DropdownMenuItem>
              </DropdownMenuContent>
            </DropdownMenu>

            <DropdownMenu>
              <DropdownMenuTrigger asChild>
                <Button variant="ghost" className="flex items-center space-x-1">
                  <span>Shops</span>
                  <ChevronDown className="h-4 w-4" />
                </Button>
              </DropdownMenuTrigger>
              <DropdownMenuContent>
                <DropdownMenuItem>Restaurants</DropdownMenuItem>
                <DropdownMenuItem>Grocery Stores</DropdownMenuItem>
                <DropdownMenuItem>Clothing Stores</DropdownMenuItem>
                <DropdownMenuItem>Electronics</DropdownMenuItem>
                <DropdownMenuItem>Pharmacies</DropdownMenuItem>
              </DropdownMenuContent>
            </DropdownMenu>

            <DropdownMenu>
              <DropdownMenuTrigger asChild>
                <Button variant="ghost" className="flex items-center space-x-1">
                  <span>Products</span>
                  <ChevronDown className="h-4 w-4" />
                </Button>
              </DropdownMenuTrigger>
              <DropdownMenuContent>
                <DropdownMenuItem>Electronics</DropdownMenuItem>
                <DropdownMenuItem>Home & Garden</DropdownMenuItem>
                <DropdownMenuItem>Fashion</DropdownMenuItem>
                <DropdownMenuItem>Food & Beverages</DropdownMenuItem>
                <DropdownMenuItem>Health & Beauty</DropdownMenuItem>
              </DropdownMenuContent>
            </DropdownMenu>

            <DropdownMenu>
              <DropdownMenuTrigger asChild>
                <Button variant="ghost" className="flex items-center space-x-1">
                  <span>Services</span>
                  <ChevronDown className="h-4 w-4" />
                </Button>
              </DropdownMenuTrigger>
              <DropdownMenuContent>
                <DropdownMenuItem>Home Services</DropdownMenuItem>
                <DropdownMenuItem>Personal Care</DropdownMenuItem>
                <DropdownMenuItem>Education</DropdownMenuItem>
                <DropdownMenuItem>Health & Wellness</DropdownMenuItem>
                <DropdownMenuItem>Business Services</DropdownMenuItem>
              </DropdownMenuContent>
            </DropdownMenu>
          </nav>
        </div>
      </div>
    </header>
  )
}
