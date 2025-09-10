import './globals.css';

export const metadata = {
  title: 'BiteRater',
  description: 'Frontend for BiteRater',
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body>{children}</body>
    </html>
  );
}

