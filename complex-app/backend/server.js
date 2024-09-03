const express = require("express");
const mongoose = require("mongoose");
const app = express();
const port = process.env.PORT || 5000;

app.use(express.json()); // To parse JSON bodies

mongoose
  .connect(process.env.MONGO_URI, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })
  .then(() => console.log("MongoDB connected..."))
  .catch((err) => console.log(err));

// Define User schema and model
const userSchema = new mongoose.Schema({
  name: {
    type: String,
    required: true,
  },
  email: {
    type: String,
    required: true,
    unique: true,
  },
});

const User = mongoose.model("User", userSchema);

// Test Backend connection with MongoDB
app.get("/api/test-connection", async (req, res) => {
  try {
    await mongoose.connection.db.admin().ping();
    res.json({ message: "MongoDB connection is successful!" });
  } catch (err) {
    res.status(500).json({ message: "MongoDB connection failed", error: err });
  }
});

// Create a new user
app.post("/api/users", async (req, res) => {
  try {
    const user = new User(req.body);
    await user.save();
    res.status(201).json(user);
  } catch (err) {
    res.status(400).json({ message: "Failed to create user", error: err });
  }
});

// Get all users
app.get("/api/users", async (req, res) => {
  try {
    const users = await User.find();
    res.json(users);
  } catch (err) {
    res.status(500).json({ message: "Failed to fetch users", error: err });
  }
});

// Get a user by ID
app.get("/api/users/:id", async (req, res) => {
  try {
    const user = await User.findById(req.params.id);
    if (!user) {
      return res.status(404).json({ message: "User not found" });
    }
    res.json(user);
  } catch (err) {
    res.status(500).json({ message: "Failed to fetch user", error: err });
  }
});

// Update a user by ID
app.put("/api/users/:id", async (req, res) => {
  try {
    const user = await User.findByIdAndUpdate(req.params.id, req.body, {
      new: true,
      runValidators: true,
    });
    if (!user) {
      return res.status(404).json({ message: "User not found" });
    }
    res.json(user);
  } catch (err) {
    res.status(400).json({ message: "Failed to update user", error: err });
  }
});

// Delete a user by ID
app.delete("/api/users/:id", async (req, res) => {
  try {
    const user = await User.findByIdAndDelete(req.params.id);
    if (!user) {
      return res.status(404).json({ message: "User not found" });
    }
    res.json({ message: "User deleted successfully" });
  } catch (err) {
    res.status(500).json({ message: "Failed to delete user", error: err });
  }
});

// Test the root route
app.get("/", (req, res) => {
  const htmlContent = `
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <title>Backend - Running Successfully</title>
      <style>
          body {
              font-family: Arial, sans-serif;
              display: flex;
              justify-content: center;
              align-items: center;
              height: 100vh;
              margin: 0;
              background-color: #f4f4f4;
          }
          .container {
              text-align: center;
              background-color: #fff;
              padding: 20px;
              border-radius: 8px;
              box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
          }
          h1 {
              color: #333;
              margin-bottom: 10px;
          }
          p {
              color: #666;
          }
      </style>
  </head>
  <body>
      <div class="container">
          <h1>Backend is Running</h1>
          <p>Your Express server is up and running smoothly!</p>
      </div>
  </body>
  </html>
  `;
  res.send(htmlContent);
});

app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});
