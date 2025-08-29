import { defineConfig } from "vite";
import react from "@vitejs/plugin-react"; // or other framework plugin
import tailwindcss from "tailwindcss";

export default defineConfig({
  plugins: [react()],
  css: {
    postcss: {
      plugins: [tailwindcss()],
    },
  },
  optimizeDeps: {
    exclude: ["js-big-decimal"],
  },
});
