"use client"

import type React from "react"
import { Star } from "lucide-react"
import { Card, CardContent } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"
import Image from "next/image"

const featuredProducts = [
  {
    id: 1,
    name: "Fresh Organic Apples",
    price: "$4.99",
    rating: 4.8,
    shop: "Green Grocer",
    image: "/placeholder.svg?height=200&width=200",
  },
  {
    id: 2,
    name: "Artisan Bread",
    price: "$6.50",
    rating: 4.9,
    shop: "Local Bakery",
    image: "/placeholder.svg?height=200&width=200",
  },
  {
    id: 3,
    name: "Handmade Soap",
    price: "$8.99",
    rating: 4.7,
    shop: "Natural Care",
    image: "/placeholder.svg?height=200&width=200",
  },
  {
    id: 4,
    name: "Coffee Beans",
    price: "$12.99",
    rating: 4.9,
    shop: "Roast Masters",
    image: "/placeholder.svg?height=200&width=200",
  },
  {
    id: 5,
    name: "Local Honey",
    price: "$9.99",
    rating: 4.8,
    shop: "Bee Farm",
    image: "/placeholder.svg?height=200&width=200",
  },
]

const topProfessionals = [
  {
    id: 1,
    name: "John Smith",
    service: "Plumbing",
    rating: 4.9,
    reviews: 127,
    image: "/placeholder.svg?height=200&width=200",
  },
  {
    id: 2,
    name: "Sarah Johnson",
    service: "House Cleaning",
    rating: 4.8,
    reviews: 89,
    image: "/placeholder.svg?height=200&width=200",
  },
  {
    id: 3,
    name: "Mike Wilson",
    service: "Electrical",
    rating: 4.9,
    reviews: 156,
    image: "/placeholder.svg?height=200&width=200",
  },
  {
    id: 4,
    name: "Lisa Brown",
    service: "Tutoring",
    rating: 4.7,
    reviews: 73,
    image: "/placeholder.svg?height=200&width=200",
  },
  {
    id: 5,
    name: "David Lee",
    service: "Personal Training",
    rating: 4.8,
    reviews: 94,
    image: "/placeholder.svg?height=200&width=200",
  },
]

const popularShops = [
  { id: 1, name: "Corner Deli", category: "Food", rating: 4.6, image: "/placeholder.svg?height=200&width=200" },
  {
    id: 2,
    name: "Fashion Boutique",
    category: "Clothing",
    rating: 4.7,
    image: "/placeholder.svg?height=200&width=200",
  },
  { id: 3, name: "Tech Store", category: "Electronics", rating: 4.5, image: "/placeholder.svg?height=200&width=200" },
  {
    id: 4,
    name: "Garden Center",
    category: "Home & Garden",
    rating: 4.8,
    image: "/placeholder.svg?height=200&width=200",
  },
  { id: 5, name: "Book Nook", category: "Books", rating: 4.9, image: "/placeholder.svg?height=200&width=200" },
]

function CarouselSection({ title, children }: { title: string; children: React.ReactNode }) {
  return (
    <section className="py-8">
      <div className="container mx-auto px-4">
        <h2 className="text-2xl font-bold mb-6">{title}</h2>
        {children}
      </div>
    </section>
  )
}

function ProductCard({ product }: { product: (typeof featuredProducts)[0] }) {
  return (
    <Card className="min-w-[250px] hover:shadow-lg transition-shadow">
      <CardContent className="p-4">
        <div className="aspect-square mb-3">
          <Image
            src={product.image || "/placeholder.svg"}
            alt={product.name}
            width={200}
            height={200}
            className="w-full h-full object-cover rounded-md"
          />
        </div>
        <h3 className="font-semibold mb-1">{product.name}</h3>
        <p className="text-sm text-gray-600 mb-2">{product.shop}</p>
        <div className="flex items-center justify-between">
          <span className="font-bold text-primary">{product.price}</span>
          <div className="flex items-center">
            <Star className="h-4 w-4 fill-yellow-400 text-yellow-400" />
            <span className="text-sm ml-1">{product.rating}</span>
          </div>
        </div>
      </CardContent>
    </Card>
  )
}

function ProfessionalCard({ professional }: { professional: (typeof topProfessionals)[0] }) {
  return (
    <Card className="min-w-[250px] hover:shadow-lg transition-shadow">
      <CardContent className="p-4">
        <div className="aspect-square mb-3">
          <Image
            src={professional.image || "/placeholder.svg"}
            alt={professional.name}
            width={200}
            height={200}
            className="w-full h-full object-cover rounded-full"
          />
        </div>
        <h3 className="font-semibold mb-1">{professional.name}</h3>
        <Badge variant="secondary" className="mb-2">
          {professional.service}
        </Badge>
        <div className="flex items-center justify-between">
          <div className="flex items-center">
            <Star className="h-4 w-4 fill-yellow-400 text-yellow-400" />
            <span className="text-sm ml-1">{professional.rating}</span>
          </div>
          <span className="text-sm text-gray-600">{professional.reviews} reviews</span>
        </div>
      </CardContent>
    </Card>
  )
}

function ShopCard({ shop }: { shop: (typeof popularShops)[0] }) {
  return (
    <Card className="min-w-[250px] hover:shadow-lg transition-shadow">
      <CardContent className="p-4">
        <div className="aspect-square mb-3">
          <Image
            src={shop.image || "/placeholder.svg"}
            alt={shop.name}
            width={200}
            height={200}
            className="w-full h-full object-cover rounded-md"
          />
        </div>
        <h3 className="font-semibold mb-1">{shop.name}</h3>
        <p className="text-sm text-gray-600 mb-2">{shop.category}</p>
        <div className="flex items-center">
          <Star className="h-4 w-4 fill-yellow-400 text-yellow-400" />
          <span className="text-sm ml-1">{shop.rating}</span>
        </div>
      </CardContent>
    </Card>
  )
}

function ScrollableCarousel({ children }: { children: React.ReactNode }) {
  return (
    <div className="relative">
      <div className="flex space-x-4 overflow-x-auto pb-4 scrollbar-hide">{children}</div>
    </div>
  )
}

export function SuggestionCarousels() {
  return (
    <div className="bg-gray-50">
      <CarouselSection title="Featured Products">
        <ScrollableCarousel>
          {featuredProducts.map((product) => (
            <ProductCard key={product.id} product={product} />
          ))}
        </ScrollableCarousel>
      </CarouselSection>

      <CarouselSection title="Top Rated Professionals">
        <ScrollableCarousel>
          {topProfessionals.map((professional) => (
            <ProfessionalCard key={professional.id} professional={professional} />
          ))}
        </ScrollableCarousel>
      </CarouselSection>

      <CarouselSection title="Popular Local Shops">
        <ScrollableCarousel>
          {popularShops.map((shop) => (
            <ShopCard key={shop.id} shop={shop} />
          ))}
        </ScrollableCarousel>
      </CarouselSection>
    </div>
  )
}
