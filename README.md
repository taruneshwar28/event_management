# Event Management
# API Documentation
## Base URL
http://localhost:8080/api/events

## Endpoints

### Create Event
POST /api/events

Request:
{
  "name": "Tech Event",
  "location": "Delhi",
  "date": "2026-02-10",
  "description": "Conference"
}

Response:
{
  "id": 1,
  "name": "Tech Event",
  "location": "Delhi",
  "date": "2026-02-10",
  "description": "Conference"
}

### Get Event by ID
GET /api/events/{id}

Error:
{
  "error": "Event not found"
}
