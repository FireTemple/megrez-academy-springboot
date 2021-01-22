(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d2bb490"],{"8f95":function(e,t,o){},"9b21":function(e,t,o){"use strict";var l=o("8f95"),a=o.n(l);a.a},e24b:function(e,t,o){"use strict";o.r(t);var l=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("div",{staticClass:"crumbs"},[o("el-breadcrumb",{attrs:{separator:"/"}},[o("el-breadcrumb-item",[o("i",{staticClass:"el-icon-lx-calendar"}),e._v(" 表单")]),o("el-breadcrumb-item",[e._v("Add item page")])],1)],1),o("div",{staticClass:"container"},[o("div",{staticClass:"form-box"},[o("el-form",{ref:"tour",attrs:{model:e.tour,"label-width":"80px"}},[o("h4",[e._v("Basic Information")]),o("el-form-item",{attrs:{label:"Tour name",prop:"name"}},[o("el-input",{model:{value:e.tour.name,callback:function(t){e.$set(e.tour,"name",t)},expression:"tour.name"}})],1),o("el-form-item",{attrs:{label:"description",prop:"description"}},[o("el-input",{model:{value:e.tour.description,callback:function(t){e.$set(e.tour,"description",t)},expression:"tour.description"}})],1),o("el-form-item",{attrs:{label:"details",prop:"details"}},[o("el-input",{model:{value:e.tour.details,callback:function(t){e.$set(e.tour,"details",t)},expression:"tour.details"}})],1),o("el-form-item",{attrs:{label:"duration",prop:"duration"}},[o("el-input",{model:{value:e.tour.duration,callback:function(t){e.$set(e.tour,"duration",t)},expression:"tour.duration"}})],1),o("el-form-item",{attrs:{label:"max duration",prop:"maxDuration"}},[o("el-input",{model:{value:e.tour.maxDuration,callback:function(t){e.$set(e.tour,"maxDuration",t)},expression:"tour.maxDuration"}})],1),o("el-form-item",{attrs:{label:"country",prop:"country"}},[o("el-select",{attrs:{placeholder:"country"},on:{change:e.selectArea},model:{value:e.tour.country,callback:function(t){e.$set(e.tour,"country",t)},expression:"tour.country"}},[o("el-option",{key:"1",attrs:{label:"India",value:"India"}}),o("el-option",{key:"2",attrs:{label:"USA",value:"USA"}}),o("el-option",{key:"3",attrs:{label:"France",value:"France"}}),o("el-option",{key:"4",attrs:{label:"Germany",value:"Germany"}}),o("el-option",{key:"5",attrs:{label:"Spain",value:"Spain"}}),o("el-option",{key:"6",attrs:{label:"Qatar",value:"Qatar"}})],1)],1),o("el-form-item",{attrs:{label:"Area",prop:"countryArea"}},[o("el-select",{attrs:{placeholder:"area"},model:{value:e.tour.countryArea,callback:function(t){e.$set(e.tour,"countryArea",t)},expression:"tour.countryArea"}},e._l(e.currentOption,(function(e){return o("el-option",{key:e.key,attrs:{label:e.label,value:e.content}})})),1)],1),o("el-form-item",{attrs:{label:"details link",prop:"detailsLink"}},[o("el-input",{model:{value:e.tour.detailsLink,callback:function(t){e.$set(e.tour,"detailsLink",t)},expression:"tour.detailsLink"}})],1),o("el-form-item",{attrs:{label:"tour status",prop:"status"}},[o("el-select",{attrs:{placeholder:"1: active,2: inactive,3: deleted"},model:{value:e.tour.status,callback:function(t){e.$set(e.tour,"status",t)},expression:"tour.status"}},[o("el-option",{key:"1",attrs:{label:"active",value:"1"}}),o("el-option",{key:"2",attrs:{label:"inactive",value:"2"}}),o("el-option",{key:"3",attrs:{label:"deleted",value:"3"}})],1)],1),o("el-form-item",{attrs:{label:"past price",prop:"pPrice"}},[o("el-input",{model:{value:e.tour.pPrice,callback:function(t){e.$set(e.tour,"pPrice",t)},expression:"tour.pPrice"}})],1),o("el-form-item",{attrs:{label:"current price",prop:"cPrice"}},[o("el-input",{model:{value:e.tour.cPrice,callback:function(t){e.$set(e.tour,"cPrice",t)},expression:"tour.cPrice"}})],1),o("el-form-item",{attrs:{label:"type",prop:"type"}},[o("el-select",{attrs:{placeholder:"popular top-rate normal"},model:{value:e.tour.type,callback:function(t){e.$set(e.tour,"type",t)},expression:"tour.type"}},[o("el-option",{key:"1",attrs:{label:"popular",value:"3"}}),o("el-option",{key:"2",attrs:{label:"top rate",value:"2"}}),o("el-option",{key:"3",attrs:{label:"normal",value:"1"}})],1)],1),o("h4",[e._v("Services")]),o("el-form-item",{attrs:{label:"Accessibility",prop:"hasAccessibility"}},[o("el-select",{attrs:{placeholder:"no"},model:{value:e.tour.hasAccessibility,callback:function(t){e.$set(e.tour,"hasAccessibility",t)},expression:"tour.hasAccessibility"}},[o("el-option",{key:"1",attrs:{label:"has",value:"1"}}),o("el-option",{key:"2",attrs:{label:"no",value:"2"}})],1)],1),o("el-form-item",{attrs:{label:"allot pet",prop:"isAllowedPet"}},[o("el-select",{attrs:{placeholder:"no"},model:{value:e.tour.isAllowedPet,callback:function(t){e.$set(e.tour,"isAllowedPet",t)},expression:"tour.isAllowedPet"}},[o("el-option",{key:"1",attrs:{label:"yes",value:"1"}}),o("el-option",{key:"2",attrs:{label:"no",value:"2"}})],1)],1),o("el-form-item",{attrs:{label:"has audio guide",prop:"hasAudioGuide"}},[o("el-select",{attrs:{placeholder:"no"},model:{value:e.tour.hasAudioGuide,callback:function(t){e.$set(e.tour,"hasAudioGuide",t)},expression:"tour.hasAudioGuide"}},[o("el-option",{key:"1",attrs:{label:"has",value:"1"}}),o("el-option",{key:"2",attrs:{label:"no",value:"2"}})],1)],1),o("el-form-item",{attrs:{label:"has tour guide",prop:"hasTourGuide"}},[o("el-select",{attrs:{placeholder:"no"},model:{value:e.tour.hasTourGuide,callback:function(t){e.$set(e.tour,"hasTourGuide",t)},expression:"tour.hasTourGuide"}},[o("el-option",{key:"1",attrs:{label:"has",value:"1"}}),o("el-option",{key:"2",attrs:{label:"no",value:"2"}})],1)],1),o("el-form-item",{attrs:{label:"item description",prop:"includeDescription"}},[o("el-input",{model:{value:e.tour.includeDescription,callback:function(t){e.$set(e.tour,"includeDescription",t)},expression:"tour.includeDescription"}})],1),e._l(e.tour.includeItems,(function(t,l){return o("el-form-item",{key:t.key,attrs:{label:"item "+l,prop:"includeItems"}},[o("el-input",{model:{value:t.content,callback:function(o){e.$set(t,"content",o)},expression:"item.content"}}),o("el-button",{on:{click:function(o){return o.preventDefault(),e.removeItem(t)}}},[e._v("delete")])],1)})),o("el-form-item",[o("el-button",{on:{click:e.addDomain}},[e._v("add")])],1),o("el-form-item",[o("el-button",{attrs:{type:"primary"},on:{click:e.createTour}},[e._v("Create")]),o("el-button",{on:{click:function(t){return e.resetForm("tour")}}},[e._v("Clean")])],1)],2)],1)])])},a=[],r={name:"itemForm",data:function(){return{tour:{name:"",description:"",details:"",duration:"",maxDuration:"",country:"",countryArea:"",detailsLink:"",status:"",cPrice:"",pPrice:"",type:"",hasAccessibility:"",isAllowedPet:"",hasAudioGuide:"",hasTourGuide:"",includeDescription:"",includeItems:[{content:"",key:"kjhkjhkj"}]},areasOption:[[{key:"1",label:"rohtok",content:"rohtok"},{key:"2",label:"rudrapur area",content:"rudrapur area"}],[{key:"1",label:"Detroit City",content:"Detroit City"},{key:"2",label:"Lansing",content:"Lansing"},{key:"3",label:"New York",content:"New York"},{key:"4",label:"Ann Arbor",content:"Ann Arbor"},{key:"5",label:"Toledo",content:"Toledo"}]],currentOption:[]}},methods:{selectArea:function(){"India"===this.tour.country?this.currentOption=this.areasOption[0]:"USA"===this.tour.country&&(this.currentOption=this.areasOption[1]),this.tour.countryArea=""},createTour:function(){var e=this,t=JSON.stringify(this.tour);console.log(t),this.$axios({method:"post",url:"/api/tour",data:t}).then((function(t){console.log(t),e.$message.success(t.msg)})).catch((function(t){e.$message.info(t)}))},removeItem:function(e){var t=this.tour.includeItems.indexOf(e);-1!==t&&this.tour.includeItems.splice(t,1)},addDomain:function(){this.tour.includeItems.push({value:"",key:Date.now()})},resetForm:function(e){this.$refs[e].resetFields(),this.$message.success("success!")}}},i=r,n=(o("9b21"),o("2877")),s=Object(n["a"])(i,l,a,!1,null,"ae6a9470",null);t["default"]=s.exports}}]);
//# sourceMappingURL=chunk-2d2bb490.7b427936.js.map