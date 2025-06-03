import { Header } from "@/components/header"
import { HeroCarousel } from "@/components/hero-carousel"
import { SuggestionCarousels } from "@/components/suggestion-carousels"

export default function HomePage() {
  return (
    <div className="min-h-screen bg-background">
      <Header />
      <main>
        <HeroCarousel />
        <SuggestionCarousels />
      </main>
    </div>
  )
}
