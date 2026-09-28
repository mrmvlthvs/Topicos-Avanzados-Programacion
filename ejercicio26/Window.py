import wx
 
class Window(wx.Frame):
    def __init__(self, title):
        super().__init__(parent = None, title = title)
        self.panel = wx.Panel(self)     
     
        toolbar = self.CreateToolBar()
 
        # Tool 1
        toolbar.AddTool(wx.ID_ANY, "Open",
                        wx.Bitmap("Open.bmp"))
 
        # Tool 2
        toolbar.AddTool(wx.ID_ANY, "Save",
                        wx.Bitmap("Save.bmp"))
 
        # Tool 3
        toolbar.AddCheckTool(wx.ID_ANY, "Highlight",
                             wx.Bitmap("Highlight.bmp"))
 
        # Tool 4
        combo = wx.ComboBox(toolbar, choices=["Option1","Option2"])
        toolbar.AddControl(combo)
         
        toolbar.Realize()  
        self.Centre()
        self.Show()
       
app = wx.App()
window = Window("WxPython Tutorial")
app.MainLoop()