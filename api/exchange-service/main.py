from fastapi import FastAPI
import httpx

app = FastAPI()

@app.get("/exchange-rate/{from_curr}/{to}")
async def get_exchange_rate(from_curr, to):
    url = f"https://v6.exchangerate-api.com/v6/76bbd4fd2f0355465749613c/pair/{from_curr}/{to}"
    async with httpx.AsyncClient() as client:
        response = await client.get(url)
    return response.json()